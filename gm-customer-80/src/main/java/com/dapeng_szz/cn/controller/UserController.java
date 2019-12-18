package com.dapeng_szz.cn.controller;

import com.dapeng_szz.cn.client.OrderClinetService;
import com.dapeng_szz.cn.client.UserClientService;
import com.dapeng_szz.cn.pojo.Order;
import com.dapeng_szz.cn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserClientService userClientService;

    @Autowired
    private OrderClinetService orderClinetService;


    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id){
        return userClientService.getUserById(id);
    }

    @GetMapping("/getOrder/{userId}")
    public List<Order> getUserOrder(@PathVariable("userId") Long userId){
        return orderClinetService.selectOrderByUserId(userId);
    }
}
