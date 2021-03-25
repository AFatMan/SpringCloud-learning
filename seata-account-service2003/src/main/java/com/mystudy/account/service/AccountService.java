package com.mystudy.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mystudy.account.entity.Account;

import java.math.BigDecimal;

/**
 * @Author 刘健生
 * @Date 2021-03-25 18:25
 * @Description
 */
public interface AccountService extends IService<Account> {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);
}
