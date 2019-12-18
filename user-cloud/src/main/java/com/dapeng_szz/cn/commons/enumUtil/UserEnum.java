package com.dapeng_szz.cn.commons.enumUtil;

public enum  UserEnum {

    USER_SESSION("user","用户名");

    private String value;
    private String text;

    UserEnum(String user, String text) {
        this.value=user;
        this.text=text;
    }

    private String getValue() {
        return value;
    }

    private String getText() {
        return text;
    }

    public UserEnum getInstance(String text){
        UserEnum[] values = UserEnum.values();
        for (UserEnum userEnum : values) {
            if (text.equalsIgnoreCase(userEnum.value)){
                return userEnum;
            }
        }
        throw new IllegalArgumentException("text值非法，没有符合分类状态的枚举对象");

    }
}
