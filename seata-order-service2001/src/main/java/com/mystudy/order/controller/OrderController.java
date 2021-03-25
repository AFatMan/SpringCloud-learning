package com.mystudy.order.controller;

import com.mystudy.order.entity.CommonResult;
import com.mystudy.order.entity.Order;
import com.mystudy.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 刘健生
 * @Date 2021-03-25 16:57
 * @Description
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.save(order);
        return new CommonResult(200,"订单创建成功");
    }
}