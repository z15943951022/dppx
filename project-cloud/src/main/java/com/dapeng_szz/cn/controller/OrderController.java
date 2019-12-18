package com.dapeng_szz.cn.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dapeng_szz.cn.dao.OrderMapper;
import com.dapeng_szz.cn.pojo.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@Api(tags = "订单功能模块")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;


    @GetMapping("/get/{orderId}")
    @ApiImplicitParam(name = "orderId", value = "订单号",required = true,dataType = "String",paramType = "path")
    @ApiOperation(value = "获取订单信息",notes = "订单信息",response = Order.class,responseContainer = "Item",
            produces = "application/json")
    public ResponseEntity getOrderById(@PathVariable("orderId") String orderId){
        return ResponseEntity.ok().body(
                orderMapper.selectById(orderId)
        );
    }

    @GetMapping("/insert")
    @ApiOperation(value = "添加订单信息",notes = "添加订单")
    public ResponseEntity testArInsert(){
        Order order = Order.builder()
                .orderId(new Date().getTime()+"")
                .userId(1l)
                .addressDetail("济南继承中心")
                .phone("15943951022")
                .total(1000.0)
                .consignee("单昭铮")
                .creatDate(new Date())
                .build();
        boolean insert = order.insert();
        return ResponseEntity.ok().body(insert);
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询订单信息",notes = "分页查询订单")
    public ResponseEntity selectPage(){
        IPage<Order> orderIPage = orderMapper.selectPage(new Page<>(1, 3), null);
        log.info(orderIPage.getTotal()+"");
        return ResponseEntity.ok().body(orderIPage.getRecords());

    }

    @GetMapping("/orderList/{userId}")
    public List<Order> selectOrderByUserId(@PathVariable("userId") Long userId){
        return orderMapper.selectList(Wrappers.<Order>lambdaQuery().eq(Order::getUserId,userId));
    }
}
