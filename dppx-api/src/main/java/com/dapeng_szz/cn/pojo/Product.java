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
@TableName(value = "Product")
public class Product {

  @TableId
  private Long productId;
  @TableField
  private Long productTypeId;
  private String title;
  @TableField
  private String productDetail;
  private Double price;
  @TableField
  private Double sellingPrice;
  @TableField
  private String picPath;
  @TableField
  private String productAttr;
  private Long pcs;

}
