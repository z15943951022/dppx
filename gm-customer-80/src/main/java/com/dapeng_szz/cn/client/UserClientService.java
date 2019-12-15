package com.dapeng_szz.cn.client;

import com.dapeng_szz.cn.pojo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Component
@FeignClient(value = "USER-CLOUD" ,fallback = UserClientService.UserClientServiceFallbackFactory.class  )
public interface UserClientService {

    @PostMapping("/user/login")
    ResponseEntity login(String account, String passWord, HttpSession session);

    @GetMapping("/user/get/{id}")
    User getUserById(@PathVariable Long id);

    @Slf4j
    @Component
    class UserClientServiceFallbackFactory implements FallbackFactory{


        @Override
        public Object create(Throwable throwable) {
            return new UserClientService() {
                @Override
                public ResponseEntity login(String account, String passWord, HttpSession session) {
                    log.warn("触发熔断==>login");
                    return ResponseEntity.ok("访问出错");
                }

                @Override
                public User getUserById(Long id) {
                    log.warn("触发熔断==>getUserById");
                    return User.builder().build();
                }
            };
        }
    }

}


