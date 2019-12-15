package com.dapeng_szz.cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dapeng_szz.cn.commons.aop.LogActive;
import com.dapeng_szz.cn.dao.UserMapper;
import com.dapeng_szz.cn.pojo.User;
import com.dapeng_szz.cn.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);



    @Override
    public User getUserbyUserNameAndpassWord(String account, String type) {
        Assert.isNull(account,"账号为空");
        Assert.isNull(type,"账号类型为空");
        LambdaQueryWrapper<User> qw=null;
        if ("1".equals(type)){
            qw= Wrappers.<User>lambdaQuery().eq(User::getUserName, account);
        }else if ("2".equals(type)){
            qw= Wrappers.<User>lambdaQuery().eq(User::getPhone, account);
        }else if ("3".equals(type)){
            qw= Wrappers.<User>lambdaQuery().eq(User::getEmail, account);
        }
        return userMapper.selectOne(qw);
    }

    @Override
    public int UserLogin(User user,String account) {
        Assert.isNull(user,"数据封装失败！");
        if (StringUtils.isBlank(user.getPassword())){
            return 0;
        }
        if (StringUtils.isBlank(account)){
            return -1;
        }

        User newUser = new User();
        newUser = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, account));
        if (newUser==null){
            newUser = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getPhone, account));
            if (newUser ==null)
                newUser = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getEmail, account));
        }
        if (newUser == null){
            return -1;
        }else if (!newUser.getPassword().equals(user.getPassword())){
            return 0;
        }else {
            user.builder()
                    .userId(newUser.getUserId())
                    .email(newUser.getEmail())
                    .money(newUser.getMoney())
                    .password(newUser.getPassword())
                    .phone(newUser.getPhone())
                    .picPath(newUser.getPicPath())
                    .sex(newUser.getSex())
                    .type(newUser.getType())
                    .userPetName(newUser.getUserPetName())
                    .build();
            return 1;
        }
    }

    @Override
    public User getUserById(Long id){
        User o = (User)redisTemplate.opsForValue().get(id);
        logger.info("查询缓存");
        if (o == null){
            User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserId, id));
            logger.info("查询数据库");
            redisTemplate.opsForValue().set(id,user);
            logger.info("放入数据库");
            return user;
        }else {
            return o;
        }
    }
}
