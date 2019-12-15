package com.dapeng_szz.cn.controller;

import com.dapeng_szz.cn.commons.enumUtil.UserEnum;
import com.dapeng_szz.cn.pojo.User;
import com.dapeng_szz.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(String account, String passWord, HttpSession session){
        User user = User.builder().password(passWord).build();
        int i = userService.UserLogin(user, account);
        if (i==-1){
            return ResponseEntity.status(401).body("用户名错误");
        }else if (i==0){
            return ResponseEntity.status(401).body("密码错误");
        }else {
            session.setAttribute(String.valueOf(UserEnum.USER_SESSION),user);
            return ResponseEntity.ok().body(user);
        }
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
}
