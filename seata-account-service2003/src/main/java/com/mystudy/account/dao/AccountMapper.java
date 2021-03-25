package com.mystudy.account.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mystudy.account.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author 刘健生
 * @Date 2021-03-25 16:13
 * @Description
 */
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
