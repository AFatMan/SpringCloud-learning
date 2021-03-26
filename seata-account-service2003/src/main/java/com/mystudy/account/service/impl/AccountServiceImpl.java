package com.mystudy.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mystudy.account.dao.AccountMapper;
import com.mystudy.account.entity.Account;
import com.mystudy.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author 刘健生
 * @Date 2021-03-25 18:26
 * @Description
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Resource
    AccountMapper accountMapper;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        // 模拟超时异常,测试@GlobalTransactional全局事务注解作用
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountMapper.decrease(userId, money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
