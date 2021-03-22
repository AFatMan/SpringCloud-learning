package com.mystudy.stream.service.impl;

import com.mystudy.stream.service.ReceiveService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @Author 刘健生
 * @Date 2021-03-22 09:46
 * @Description
 */
@EnableBinding(Sink.class)
public class ReceiveServiceImpl implements ReceiveService {

    @Value("${server.port}")
    String port;

    @Override
    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message) {
        String payload = message.getPayload();
        System.out.println("消费者"+port+"接收到的信息是:"+payload);
    }
}
