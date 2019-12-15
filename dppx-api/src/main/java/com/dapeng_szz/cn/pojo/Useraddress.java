package com.dapeng_szz.cn.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Accessors(chain = true)
public class Useraddress {

  private long addressId;
  private long userId;
  private String consignee;
  private String addressDetail;
  private String phone;
  private long defaultBoolean;



}
