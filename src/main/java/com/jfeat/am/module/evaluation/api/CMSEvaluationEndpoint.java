package com.jfeat.am.module.evaluation.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.core.shiro.ShiroKit;
import com.jfeat.am.module.evaluation.api.permission.EvaluationPermission;
import com.jfeat.am.module.evaluation.services.crud.filter.StockEvaluationFilter;
import com.jfeat.am.module.evaluation.services.definition.EvaluationType;
import com.jfeat.am.module.evaluation.services.domain.dao.QueryStockEvaluationDao;
import com.jfeat.am.module.evaluation.services.domain.model.StockEvaluationModel;
import com.jfeat.am.module.evaluation.services.domain.model.record.StockEvaluationRecord;
import com.jfeat.am.module.evaluation.services.domain.model.record.StockEvaluationStarRecord;
import com.jfeat.am.module.evaluation.services.domain.service.StockEvaluationService;
import com.jfeat.am.module.evaluation.services.model.StockEvaluationRecord2;
import com.jfeat.am.module.evaluation.services.persistence.model.StockEvaluationStar;
import com.jfeat.am.module.evaluation.services.request.IdsRequest;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.notification.services.crud.service.SubscriptionService;
import com.jfeat.am.module.notification.services.crud.service.UserNotifyService;
import com.jfeat.am.module.notification.services.persistence.model.Notify;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderItemMapper;
import com.jfeat.am.module.order.services.gen.persistence.dao.OrderMapper;
import com.jfeat.am.module.order.services.gen.persistence.model.Order;
import com.jfeat.am.module.order.services.gen.persistence.model.OrderItem;
import com.jfeat.crud.plus.CRUD;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/*
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2018-07-16
 */

@RestController
@Api("evaluation-评价")
@RequestMapping("/api/cms")
public class CMSEvaluationEndpoint extends BaseController {



    @Resource
    StockEvaluationService stockEvaluationService;
    @Resource
    UserNotifyService userNotifyService;
    @Resource
    SubscriptionService subscriptionService;

    @Resource
    QueryStockEvaluationDao queryStockEvaluationDao;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private OrderMapper orderMapper;


    /**
     * 用户   操作           事件
     * U1    发表文章A1      订阅了A1
     * U2    对A1发表评论C1  订阅了C1，生成notify(sourceId:C1, targetId:A1) -> U1可以收到这个消息
     * U3    对C1发表评论C2  订阅了C2，生成notify(sourceId:C2, targetId:C1) -> U2可以收到这个消息
     * */
    @BusinessLog(name = "StockEvaluation", value = "create StockEvaluation")
    @PostMapping("/evaluations")
    @ApiOperation("新建评价，如评价文件，则带上文章的id及类型 stockId stockType,其他情况同上,回复评论时originId,originType带文章id、type")
    public Tip createArticleEvaluation(@RequestBody StockEvaluationModel entity) {

        Integer affected = 0;
        Long userId = JWTKit.getUserId(getHttpServletRequest());
        entity.setMemberId(userId);

        if(entity.getMemberName() == null || "".equals(entity.getMemberName())) {
            String userName = JWTKit.getAccount(getHttpServletRequest());
            entity.setMemberName(userName);
        }
        // 评论对象不为Evaluation时,originId、originType即stockId,stockType
        if(!EvaluationType.Evaluation.toString().equals(entity.getStockType())) {
            entity.setOriginId(entity.getStockId());
            entity.setOriginType(entity.getStockType());
        }
        try {
            StockEvaluationFilter filter = new StockEvaluationFilter();
            affected += stockEvaluationService.createMaster(entity, filter, null, null);
            Long modelId = (Long) filter.result().get("id") == null ? null : (Long) filter.result().get("id");
            entity.setId(modelId);
            // 插入消息通知
            List<String> actions = new ArrayList<>();
            actions.add("Evaluation");
            actions.add("Flower");
            actions.add("Favorite");
            actions.add("UnFavorite");
            actions.add("UnFlower");

            subscriptionService.subscribe(userId,modelId, "Evaluation",actions);
            Notify notify = new Notify();
            notify.setTargetId(entity.getStockId());
            notify.setTargetType(entity.getStockType());
            notify.setOriginType(entity.getOriginType());
            notify.setOriginId(entity.getOriginId());
            notify.setSenderId(entity.getMemberId());
            notify.setContent(entity.getContent());
            notify.setSourceId(modelId);
            notify.setSourceType(EvaluationType.Evaluation.toString());
            notify.setAction("Evaluation");
            userNotifyService.createRemind(notify);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(entity);
    }

    @GetMapping("/evaluations/{id}")
    @ApiOperation("查看评价")
    public Tip getStockEvaluation(@PathVariable Long id) {
        Page<StockEvaluationRecord> page = new Page<StockEvaluationRecord>();
        Long memberId = JWTKit.getUserId(getHttpServletRequest());
        StockEvaluationRecord record = new StockEvaluationRecord();
        record.setId(id);
        List<StockEvaluationRecord> evaluations = stockEvaluationService.evaluations(page, record, null, memberId);
        if(CollectionUtils.isEmpty(evaluations)){
            throw new BusinessException(BusinessCode.BadRequest);
        }
        StockEvaluationRecord evaluationRecord = evaluations.get(0);
        Order order = orderMapper.selectOne(new Order().setOrderNumber(evaluationRecord.getTradeNumber()));
        List<OrderItem> orderItemList = orderItemMapper.selectList(new EntityWrapper<OrderItem>().eq("order_id", order.getId()));
        String[] productNames = new String[orderItemList.size()];
        for (int i = 0; i < orderItemList.size() ; i++) {
            productNames[i] = orderItemList.get(i).getProductName();
        }
        Integer commentStar = null;
        List<StockEvaluationStar> stockEvaluationStars = evaluationRecord.getStockEvaluationStars();
        if(!CollectionUtils.isEmpty(stockEvaluationStars)){
            commentStar = stockEvaluationStars.get(0).getStarValue();
        }
        StockEvaluationRecord2 stockEvaluationRecord2 = CRUD.castObject(evaluationRecord, StockEvaluationRecord2.class);
        stockEvaluationRecord2.setCommentStar(commentStar);
        stockEvaluationRecord2.setProductNames(productNames);

        /*CRUDObject<StockEvaluationModel> stockEvaluationModelCRUDObject = stockEvaluationService.retrieveMaster(id, null, null, null);*/
        return SuccessTip.create(stockEvaluationRecord2);
    }

    @BusinessLog(name = "StockEvaluation", value = "update StockEvaluation")
    @PutMapping("/evaluations/{id}")
    @ApiOperation("修改评价")
    public Tip updateStockEvaluation(@PathVariable Long id, @RequestBody StockEvaluationModel entity) {
        Long memberId = JWTKit.getUserId(getHttpServletRequest());
        if (stockEvaluationService.retrieveMaster(id).getMemberId().compareTo(memberId) == 0 ||
                ShiroKit.hasPermission(EvaluationPermission.STOCKEVALUATION_EDIT)) {
            entity.setId(id);
            return SuccessTip.create(stockEvaluationService.updateMaster(entity, null, null, null));
        }
        throw new BusinessException(BusinessCode.BadRequest);
    }

    @BusinessLog(name = "StockEvaluation", value = "delete StockEvaluation")
    @DeleteMapping("/evaluations/{id}")
    @ApiOperation("删除评价")
    @Deprecated
    public Tip deleteStockEvaluation(@PathVariable Long id) {
        Long memberId = JWTKit.getUserId(getHttpServletRequest());
        if (stockEvaluationService.retrieveMaster(id).getMemberId().compareTo(memberId) == 0 ||
                ShiroKit.hasPermission(EvaluationPermission.STOCKEVALUATION_EDIT)) {
            return SuccessTip.create(stockEvaluationService.deleteMaster(id));
        }
        throw new BusinessException(BusinessCode.NoPermission);
    }

    @ApiOperation("商品/订单评价详情 : 默认评论与回复同级返回; 当isLayered=true时,返回分层的树形结构评论列表")
    @GetMapping("/evaluations")
    public Tip queryStockEvaluations(Page<StockEvaluationRecord> page,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(name = "stockId", required = false) Long stockId,
                                     @RequestParam(name = "stockType", required = false,defaultValue = "Product") String stockType,
                                     @RequestParam(name = "createTime", required = false) Date createTime,
                                     @RequestParam(name = "orderBy", required = false) String orderBy,
                                     @RequestParam(name = "sort", required = false) String sort,
                                     @RequestParam(name = "starValue", required = false) Integer starValue,
                                     @RequestParam(name = "tradeNumber", required = false) String tradeNumber,
                                     @RequestParam(name = "originId", required = false) Long originId,
                                     @RequestParam(name = "originType", required = false) String originType,
                                     @RequestParam(name = "isLayered", required = false, defaultValue = "false") Boolean isLayered,
                                     @RequestParam(name = "isDisplay", required = false, defaultValue = "1") Integer isDisplay


    ) {
        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        Long memberId = JWTKit.getUserId(getHttpServletRequest());

        StockEvaluationRecord record = new StockEvaluationRecord();
        record.setStockId(stockId);
        record.setStockType(stockType);
        record.setCreateTime(createTime);
        record.setStarValue(starValue);
        record.setTradeNumber(tradeNumber);
        record.setOriginType(originType);
        record.setOriginId(originId);
        record.setIsDisplay(isDisplay);
        if(isLayered) {
            page.setRecords(null/*stockEvaluationService.evaluationsOnLayered(page, record, orderBy,memberId)*/);
        } else {
            List<StockEvaluationRecord> evaluations = stockEvaluationService.evaluations(page, record, orderBy, memberId);
            List<StockEvaluationRecord> evaluationRecord2s = new ArrayList<>();
            for (StockEvaluationRecord evaluationRecord : evaluations ){
                Order order = orderMapper.selectOne(new Order().setOrderNumber(evaluationRecord.getTradeNumber()));
                List<OrderItem> orderItemList = orderItemMapper.selectList(new EntityWrapper<OrderItem>().eq("order_id", order.getId()));
                String[] productNames = new String[orderItemList.size()];
                for (int i = 0; i < orderItemList.size() ; i++) {
                    productNames[i] = orderItemList.get(i).getProductName();
                }
                Integer commentStar = null;
                List<StockEvaluationStar> stockEvaluationStars = evaluationRecord.getStockEvaluationStars();
                if(!CollectionUtils.isEmpty(stockEvaluationStars)){
                    commentStar = stockEvaluationStars.get(0).getStarValue();
                }
                StockEvaluationRecord2 stockEvaluationRecord2 = CRUD.castObject(evaluationRecord, StockEvaluationRecord2.class);
                stockEvaluationRecord2.setCommentStar(commentStar);
                stockEvaluationRecord2.setProductNames(productNames);
                evaluationRecord2s.add(stockEvaluationRecord2);
            }
            page.setRecords(evaluationRecord2s);
        }
        return SuccessTip.create(page);
    }


    @ApiOperation("评分数量")
    @GetMapping("/evaluations/starCount")
    public Tip queryStarCount(@RequestParam(name = "stockId", required = false) Long stockId,
                              @RequestParam(name = "stockType", required = false) String stockType,
                              @RequestParam(name = "createTime", required = false) Date createTime,
                              @RequestParam(name = "display", required = false) String display) {

        StockEvaluationRecord record = new StockEvaluationRecord();
        record.setStockId(stockId);
        record.setStockType(stockType);
        record.setCreateTime(createTime);

        // 对没有数据的星级初始化
        List<Integer> stars = new ArrayList<>();
        stars.addAll(Arrays.asList(1, 2, 3, 4, 5));
        List<StockEvaluationStarRecord> records = queryStockEvaluationDao.findStarCount(record, display);
        for(StockEvaluationStarRecord item : records) {
            stars.remove(item.getStarValue());
        }
        for(Integer star : stars) {
            StockEvaluationStarRecord entity = new StockEvaluationStarRecord();
            entity.setStartCount(0);
            entity.setStarValue(star);
            records.add(entity);
        }
        records.sort((o1, o2) -> o1.getStarValue() - o2.getStarValue());
        return SuccessTip.create(records);
    }

    @PostMapping("/evaluations/{id}/action/forbidden")
    @ApiOperation("屏蔽评价")
    public Tip forbiddenEvaluation(@PathVariable Long id) {

        Integer result =  stockEvaluationService.forbiddenEvaluation(id);

        return SuccessTip.create(result);
    }
    @PostMapping("/evaluations/{id}/action/stick")
    @ApiOperation("置顶评价")
    public Tip stickEvaluation(@PathVariable Long id) {
        Integer result =  stockEvaluationService.stickEvaluation(id);
        return SuccessTip.create(result);
    }

    @PostMapping("/evaluations/bulk/search")
    @ApiOperation("根据Ids批量查询评价")
    public Tip bulkQueryEvaluations(@RequestBody IdsRequest idsRquest) {
        Page<StockEvaluationRecord> page = new Page<>();
        page.setSize(idsRquest.getPageSize() == null ? 10 : idsRquest.getPageSize());
        page.setCurrent(idsRquest.getPageNum() == null ? 1 : idsRquest.getPageNum());
        page.setRecords(queryStockEvaluationDao.bulkFindEvaluations(page, idsRquest.getIds(),idsRquest.getStockIds(), idsRquest.getStockType(), idsRquest.getStarValue()));
        return SuccessTip.create(page);
    }


}
