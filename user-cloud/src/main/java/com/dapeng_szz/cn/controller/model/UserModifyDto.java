package com.dapeng_szz.cn.controller.model;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.dapeng_szz.cn.commons.enumUtil.SexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserModifyDto {
    @ApiModelProperty(value = "用户昵称")
    private String userPetName;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "性别",notes = "0 女 1 男")
    private SexEnum sex;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "头像地址")
    private String picPath;

}

