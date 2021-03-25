package com.mystudy.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author 刘健生
 * @Date 2021-03-25 16:11
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_order")
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    private Integer status; //订单状态：0：创建中；1：已完结
}
