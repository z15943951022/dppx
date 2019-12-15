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
@TableName(value = "Buycar")
public class Buycar {

  @TableId
  private Long id;
  @TableField(value = "userId")
  private Long userId;
  @TableField(value = "productId")
  private Long productId;
  @TableField(value = "productCount")
  private Long productCount;
  @TableField(value = "sellingPrice")
  private Double sellingPrice;
  @TableField(value = "buyCarSum")
  private Double buyCarSum;



}
