package com.dapeng_szz.cn.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "user")
public class User {

  @TableId("userId")
  private Long userId;
  @TableField(value = "userName")
  private String userName;
  private String password;
  @TableField(value = "userPetName")
  private String userPetName;
  private String sex;
  private String phone;
  private String email;
  @TableField(value = "picPath")
  private String picPath;
  private Double money;
  private String type;


}
