package com.dapeng_szz.cn.client;

import com.dapeng_szz.cn.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "ORDER-CLOUD",fallback =OrderClinetService.OrderClinetServiceHystrix.class )
public interface OrderClinetService {

    @GetMapping("/orderList/{userId}")
    public List<Order> selectOrderByUserId(@PathVariable("userId") Long userId);

    @Component
    @Slf4j
    class OrderClinetServiceHystrix  implements OrderClinetService{

        @Override
        public List<Order> selectOrderByUserId(Long userId) {
            log.info("触发熔断");
            List<Order> list=new ArrayList<>();
            return list;
        }
    }
}
