package com.mystudy.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mystudy.order.dao.OrderMapper;
import com.mystudy.order.entity.Order;
import com.mystudy.order.service.AccountService;
import com.mystudy.order.service.OrderService;
import com.mystudy.order.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 刘健生
 * @Date 2021-03-25 16:16
 * @Description
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService {

    @Autowired
    @Qualifier("orderMapper")
    private OrderMapper orderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    public boolean save(Order entity) {
        log.info("----->开始新建订单");
        //1 新建订单
        orderMapper.insert(entity);

        //2 扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(entity.getProductId(),entity.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3 扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(entity.getUserId(),entity.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        //4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        entity.setStatus(0);
        orderMapper.updateById(entity);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");
        return true;
    }
}
