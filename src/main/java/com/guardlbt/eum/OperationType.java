package com.guardlbt.eum;

public enum OperationType {
    LOGIN(0,"登录");


    private int state;
    private String info;

    //构造方法（枚举的构造方法只允许private类型）
    private OperationType(int state, String info){
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
