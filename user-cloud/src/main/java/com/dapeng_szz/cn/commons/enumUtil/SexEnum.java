package com.dapeng_szz.cn.commons.enumUtil;

public enum  SexEnum {

    MAN(1,"男"),

    WOMAN(0,"女");

    private Integer value;
    private String text;

    private SexEnum(Integer value,String text){
        this.value=value;
        this.text=text;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static SexEnum getInstance(String value){
        SexEnum[] values = SexEnum.values();
        for (SexEnum sexEnum : values) {
            if (value.equals(sexEnum.value)){
                return sexEnum;
            }
        }
        return null;
    }
}
