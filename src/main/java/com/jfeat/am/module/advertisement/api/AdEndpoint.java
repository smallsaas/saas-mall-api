package com.jfeat.am.module.advertisement.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.advertisement.services.persistence.dao.AdGroupMapper;
import com.jfeat.am.module.advertisement.services.persistence.model.Ad;
import com.jfeat.am.module.advertisement.services.service.AdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2017-09-20
 */
@RestController
@RequestMapping("/api")
@Api("AD-轮播图")
public class AdEndpoint extends BaseController {

    @Resource
    private AdService adService;
    @Resource
    private AdGroupMapper adGroupMapper;

    @PostMapping("/ad")
    @ApiOperation("添加广告")
    public Tip createAd(@RequestBody Ad entity) {
        entity.setEnabled(1);
        return SuccessTip.create(adService.createMaster(entity));
    }

    @PutMapping("/ad/{id}")
    @ApiOperation("更新广告")
    public Tip updateAd(@PathVariable Long id, @RequestBody Ad entity) {
        return SuccessTip.create(adService.updateMaster(entity));
    }

    @GetMapping("/pub/ad/{id}")
    @ApiOperation("广告详情")
    public Tip getAdInfo(@PathVariable Long id) {
        return SuccessTip.create(adService.retrieveMaster(id));
    }

    @DeleteMapping("/ad/{id}")
    @ApiOperation("删除广告")
    public Tip deleteAd(@PathVariable Long id) {
        return SuccessTip.create(adService.deleteMaster(id));
    }

    @PostMapping("/ad/{id}/enable")
    @ApiOperation("启用广告")
    public Tip enableAd(@PathVariable Long id) {
        Ad ad = new Ad();
        ad.setEnabled(1);
        ad.setId(id);
        return SuccessTip.create(adService.updateMaster(ad));
    }

    @PostMapping("/ad/{id}/disable")
    @ApiOperation("禁用广告")
    public Tip disableAd(@PathVariable Long id) {
        Ad ad = new Ad();
        ad.setId(id);
        ad.setEnabled(0);
        return SuccessTip.create(adService.updateMaster(ad));
    }

    @GetMapping("/pub/ad/libraries")
    @ApiOperation("图库列表")
    public Tip queryAdLibraryies(/*Page<AdLibraryRecord> page,*/
                                 @RequestParam(name = "current", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(name = "id", required = false) Long id,
                                 @RequestParam(name = "url", required = false) String url,
                                 @RequestParam(name = "orderBy", required = false) String orderBy,
                                 @RequestParam(name = "sort", required = false) String sort) {
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
       /* page.setCurrent(pageNum);
        page.setSize(pageSize);

        AdLibraryRecord record = new AdLibraryRecord();
        record.setId(id);
        record.setUrl(url);

        page.setRecords(queryAdLibraryDao.findAdLibraryPage(page, record, orderBy));
*/
        return SuccessTip.create(/*page*/);
    }
}
