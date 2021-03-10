package com.mystudy.payment.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 刘健生
 * @Date 2021-03-10 15:51
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @TableId("id")
    private Long id;
    private String serial;
}
