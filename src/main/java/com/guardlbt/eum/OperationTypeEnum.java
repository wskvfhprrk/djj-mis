package com.guardlbt.eum;

public enum OperationTypeEnum {
    LOGIN(0,"登录"),
    UPDATE(1,"更新"),
    SHARE(2,"分享");


    private int state;
    private String info;

    //构造方法（枚举的构造方法只允许private类型）
    private OperationTypeEnum(int state, String info){
        this.state = state;
        this.info = info;
    }

    public int getState(){
        return state;
    }

    public String getInfo(){
        return info;
    }
}
