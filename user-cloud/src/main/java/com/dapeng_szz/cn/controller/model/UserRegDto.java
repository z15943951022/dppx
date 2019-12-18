package com.dapeng_szz.cn.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel
@Data
public class UserRegDto {

    @NotBlank
    @ApiModelProperty(value = "用户名")
    private String UserName;
    @NotBlank
    @ApiModelProperty(value = "密码")
    private String passWord;
    @NotBlank
    @ApiModelProperty(value = "邮箱")
    private String email;
}
