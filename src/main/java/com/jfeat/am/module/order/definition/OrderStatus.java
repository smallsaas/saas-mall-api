package com.jfeat.am.module.order.definition;

/**
 * @author hero
 * @date 17:57
 */
public enum OrderStatus {

    //待支付
    CREATED_PAY_PENDING,

    //支付超时关闭
    CLOSED_PAY_TIMEOUT,

    //已取消
    CLOSED_CANCELED,

    // 已支付（配送方式为“快递”时，此状态相当于已支付，配送方式为“自提”或“极速送达”时，此状态相当于待处理）
    // 对于 试用装，从已支付可以进入 关闭状态 （拒绝申请的情况）
    PAID_CONFIRM_PENDING ,

    //待发货
    CONFIRMED_DELIVER_PENDING,

    /*
        DELIVERING表示已经通知快递了；DELIVERED_CONFIRM_PENDING表示快递已经投递了。
        由于目前还没有和快递端对接，所以DELIVERED_CONFIRM_PENDING是一样的，都是发货了。
        因此订单发货时发送通知，只需要处理DELIVERING的通知即可
     */
    //发货中
    DELIVERING,

    //已发货
    DELIVERED_CONFIRM_PENDING,

    //待退货
    CANCELED_RETURN_PENDING,

    //已确认收货
    CLOSED_CONFIRMED,

    //待退款
    CANCELED_REFUND_PENDING,

    //已退款
    CLOSED_REFUNDED,

    //待取货（对于自提的方式，用户下单并支付之后，店员在ipad端“受理”该订单，则变为“待取货”）
    CONFIRMED_PICK_PENDING;

}