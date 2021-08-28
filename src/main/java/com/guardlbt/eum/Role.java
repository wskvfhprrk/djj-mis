package com.guardlbt.eum;

public enum Role {
    BOSS(0,"老板"),
    SHOPOWNER(1,"店长"),
    SATFF(2,"员工"),
    MEMBER(3,"普通会员")
    ;


    private int state;
    private String info;

    //构造方法（枚举的构造方法只允许private类型）
    private Role(int state, String info){
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
