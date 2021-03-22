package com.mystudy.stream.service;

import org.springframework.messaging.Message;

/**
 * @Author 刘健生
 * @Date 2021-03-22 09:44
 * @Description
 */
public interface ReceiveService {

    void receiveMessage(Message<String> message);

}
