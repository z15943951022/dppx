package com.dapeng_szz.cn.config;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class IZuulFilter extends ZuulFilter {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * pre:请求执行前filter
     * route:处理请求，进行路由
     * post:请求处理完成后执行filter
     * error：出现错误执行filter
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
       return true;
    }

    @Override
    public Object run() {
        return null;
    }
}
