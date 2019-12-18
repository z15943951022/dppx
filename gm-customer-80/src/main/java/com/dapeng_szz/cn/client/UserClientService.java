package com.dapeng_szz.cn.client;

import com.dapeng_szz.cn.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "USER-CLOUD",fallback = UserClientService.UserClientServiceHystrix.class )
public interface UserClientService {

    /*@PostMapping("/login")
    ResponseEntity<Map<String,Boolean>> login(String account, String passWord,HttpSession session);*/

    @GetMapping("/get/{id}")
    User getUserById(@PathVariable(value = "id") Long id);

    @Slf4j
    @Component
    class UserClientServiceHystrix implements UserClientService{

        @Override
        public User getUserById(Long id) {
            log.info("触发熔断");
            return new User();
        }
    }

}


