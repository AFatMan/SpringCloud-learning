package com.mystudy.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mystudy.storage.entity.Storage;

/**
 * @Author 刘健生
 * @Date 2021-03-25 18:12
 * @Description
 */
public interface StorageService extends IService<Storage> {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
