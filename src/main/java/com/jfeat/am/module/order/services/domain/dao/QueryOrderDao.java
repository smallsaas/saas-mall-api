package com.jfeat.am.module.order.services.domain.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jfeat.am.module.frontproduct.services.domain.model.FrontProductRecord;
import com.jfeat.am.module.frontuser.services.gen.persistence.model.FrontUser;
import com.jfeat.am.module.order.services.domain.model.OrderRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.order.services.gen.persistence.model.TOrder;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-07-31
 */
public interface QueryOrderDao extends BaseMapper<TOrder> {
    List<OrderRecord> findOrderPage( @Param("ew") QueryWrapper queryWrapper,
                                    Page<OrderRecord> page, @Param("record") OrderRecord record,
                                    @Param("search") String search, @Param("orderBy") String orderBy,
                                    @Param("startTime") Date startTime,
                                    @Param("startEndTime") Date startEndTime,
                                    @Param("endTime") Date endTime,
                                    @Param("allianceId") Long allianceId,
                                    @Param("leftMoney") BigDecimal leftMoney,
                                    @Param("rightMoney") BigDecimal rightMoney
    );

    //查询订单 显示订单结算的时候用
    List<OrderRecord> settlementOrder(Page<OrderRecord> page, @Param("record") OrderRecord record,
                                    @Param("search") String search, @Param("orderBy") String orderBy,
                                    @Param("startTime") Date startTime,
                                    @Param("startEndTime") Date startEndTime,
                                    @Param("endTime") Date endTime,
                                    @Param("allianceId") Long allianceId,
                                       @Param("userName") String userName,
                                      @Param("leftMoney") BigDecimal leftMoney,
                                      @Param("rightMoney") BigDecimal rightMoney
    );


    Integer insertOrderItem(@Param("orderId") Long orderId, @Param("barcode") String barcode, @Param("productName") String productName, @Param("quantity") Integer quantity, @Param("finalPrice") BigDecimal finalPrice);

    List<Long> selectUserId(@Param("name") String name);

    Long selectProductId(@Param("barCode") String barCode);


    List<OrderRecord> refundOrderPage(Page<OrderRecord> page,
                                      @Param("status") String status,
                                      @Param("search") String search,
                                      @Param("orderBy") String orderBy,
                                      @Param("startTime") Date startTime,
                                      @Param("endTime") Date endTime
    );


    String getUserName( @Param("userId") Long userId);

    List<OrderRecord> getAllianceOrder(Page<OrderRecord> page,@Param("id")Long id,
            @Param("search") String search,@Param("startTime")Date startTime,@Param("endTime")Date endTime,
                                               @Param("status") String status);


    List<FrontUser> getUsers(@Param("search") String search);
    List<FrontProductRecord> getProducts(@Param("search") String search);

    FrontUser selectByUserId(@Param("id") Long id);

    @Select("select balance from t_wallet where user_id=#{userId}")
    BigDecimal queryWalletBalance(Long userId);

    @Update("update t_product set stock_balance=#{balance} where id=#{productId}")
    Integer upProduct(@Param("productId") Long productId, @Param("balance") Integer balance);

    @Update("update t_wallet set balance=#{balance} where user_id=#{userId}")
    Integer upWallet(@Param("userId") Long userId,@Param("balance") BigDecimal balance);

    Integer insertOrderItem(@Param("orderId")Long orderId,@Param("barcode")String barcode,@Param("productName")String productName,@Param("quantity")Integer quantity,@Param("finalPrice") BigDecimal finalPrice
            ,@Param("price") BigDecimal price,@Param("costPrice") BigDecimal costPrice,@Param("cover") String cover,@Param("id") Long id);



    Integer upStockBalance(@Param("productId")Integer productId,@Param("num")Integer num);


    Integer closeProduct(@Param("id")Long id);
    Integer cancelcloseProduct(@Param("id")Long id);

    @Select("select t_sys_org.tenant_id from t_sys_org where id = #{orgId} ")
    Long getTenantIdByOrgId(@Param("orgId")Long orgId);

    List<OrderRecord> getOrderRecordList(@Param("record")OrderRecord record);

    List<OrderRecord> listOrders(@Param("ids") List<Integer> ids);
}