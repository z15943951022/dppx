package com.dapeng_szz.cn.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Accessors(chain = true)
@TableName(value = "`order`")
public class Order extends Model<Order> {

  @TableId(value = "orderId")
  private String orderId;
  @TableField(value = "userId")
  private Long userId;
  private Double total;
  private String consignee;
  @TableField(value = "addressDetail")
  private String addressDetail;
  private String phone;
  @TableField(value = "creatDate")
  private Date creatDate;

  @Override
  protected Serializable pkVal() {
    return orderId;
  }

}
