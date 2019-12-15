package com.dapeng_szz.cn.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String serialNumber = request.getParameter("serialNumber");
        return !StringUtils.isEmpty(serialNumber);
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String serialNumber = request.getParameter("serialNumber");
        String verificationCode = request.getParameter("verificationCode");
        Object o = redisTemplate.opsForValue().get(serialNumber);
        if (o==null || !o.equals(verificationCode)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            currentContext.getResponse().setContentType(
                    MediaType.APPLICATION_JSON_UTF8.getType()
            );
            currentContext.setResponseBody("{'success':false,'message':'Verification Code Error'}");
        }
        return null;
    }
}
