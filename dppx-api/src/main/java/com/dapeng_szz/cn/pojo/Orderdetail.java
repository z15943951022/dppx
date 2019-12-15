package com.dapeng_szz.cn.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName(value = "Orderdetail")
public class Orderdetail {

  @TableField
  private Long orderDetailId;
  @TableField
  private Long orderId;
  @TableField
  private Long statusId;
  @TableField
  private Long productId;
  @TableField
  private String picPath;
  private String title;
  private Double price;
  @TableField
  private Double sellingPrice;
  @TableField
  private String productAttr;
  @TableField
  private Long productCount;
  @TableField
  private Double orderSum;



}
