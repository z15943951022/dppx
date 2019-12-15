package com.dapeng_szz.cn.service;


import com.dapeng_szz.cn.pojo.User;

public interface UserService {

    /**
     * 根据账号查询用户
     * type：
     *      1：userName
     *      2：手机号
     *      3：邮箱
     * @param account 【账号】
     * @param type     【账号类型】
     * @return
     */
    User getUserbyUserNameAndpassWord(String account,String type);

    /**
     * 用户登陆 【可用： 用户名，手机号，邮箱登陆】【登陆成功填充user】
     * 返回值：
     *      -1：用户名错误
     *      0：密码错误
     *      1：填充成功
     * @param user
     * @return
     */
    int UserLogin(User user,String account);

    User getUserById(Long id);
}
