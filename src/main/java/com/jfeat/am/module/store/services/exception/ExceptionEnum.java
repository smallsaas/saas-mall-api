package com.jfeat.am.module.store.services.exception;

public enum ExceptionEnum {
    NOT_AN_ASSISTANT(4000, "非店员身份！"),
    NOT_THE_NEXT_ASSISTANT(4001, "非接班人不能确认换班！"),
    NOT_THE_CURRENT_ASSISTANT(4002, "非当前值班人不能申请换班！"),
    NOT_APPLYINIG(4003, "非申请交换班状态不能确认交班！"),
    NOT_WORKING(4004, "非值班状态不能申请换班！"),
    CAN_NOT_SHIFT_TO_SELF(4005,"非法请求，无法执行自己与自己交班");

    private int friendlyCode;
    private String friendlyMsg;

    private ExceptionEnum(int code, String message) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
    }

    public int getFriendlyCode() {
        return friendlyCode;
    }

    public void setFriendlyCode(int friendlyCode) {
        this.friendlyCode = friendlyCode;
    }

    public String getFriendlyMsg() {
        return friendlyMsg;
    }

    public void setFriendlyMsg(String friendlyMsg) {
        this.friendlyMsg = friendlyMsg;
    }
}
