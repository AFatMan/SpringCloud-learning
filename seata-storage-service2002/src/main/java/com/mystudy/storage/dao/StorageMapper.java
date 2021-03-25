package com.mystudy.storage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mystudy.storage.entity.Storage;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 刘健生
 * @Date 2021-03-25 18:07
 * @Description
 */
public interface StorageMapper extends BaseMapper<Storage> {

    //扣减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
