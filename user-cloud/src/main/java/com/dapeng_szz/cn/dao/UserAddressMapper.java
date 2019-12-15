package com.dapeng_szz.cn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dapeng_szz.cn.pojo.Useraddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserAddressMapper extends BaseMapper<Useraddress> {
}
