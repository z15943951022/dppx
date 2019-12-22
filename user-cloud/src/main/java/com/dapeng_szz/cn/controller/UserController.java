package com.dapeng_szz.cn.controller;

import com.dapeng_szz.cn.commons.enumUtil.UserEnum;
import com.dapeng_szz.cn.commons.util.AuthUtil;
import com.dapeng_szz.cn.commons.util.EmailUtil;
import com.dapeng_szz.cn.controller.model.UserRegDto;
import com.dapeng_szz.cn.dao.UserMapper;
import com.dapeng_szz.cn.pojo.User;
import com.dapeng_szz.cn.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户模块")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;




    @ApiOperation(value = "用户登录",notes = "账号、邮箱、电话号都可作为账号登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="account",value = "账号",required = true,paramType = "query"),
            @ApiImplicitParam(name ="passWord",value = "密码",required = true,paramType = "query")
    })
    @PostMapping("/login")
    public Integer login(String account, String passWord,User user){
        user = User.builder().password(passWord).build();
        return userService.UserLogin(user, account);
    }


    @ApiOperation(value = "根据用户id查询用户")
    @ApiImplicitParam(name = "id",value = "用户Id",required = true,paramType = "path")
    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }



    @ApiOperation(value = "注册用户" ,notes = "注册用户(邮箱验证)")
    @ApiImplicitParam(name = "auth",value = "验证码",required = true,paramType = "query")
    @PostMapping("/registry")
    public Boolean addUser(@Validated UserRegDto userRegDto,
                                  @NotBlank(message = "验证码不能为空") String auth){
        User user = User.builder().userPetName(userRegDto.getUserName())
                .password(userRegDto.getPassWord())
                .email(userRegDto.getEmail())
                .build();
        int i = userMapper.insert(user);
        return i>0;
    }




}
