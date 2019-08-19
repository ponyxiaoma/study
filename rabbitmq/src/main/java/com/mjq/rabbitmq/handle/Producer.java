package com.mjq.rabbitmq.handle;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: majingqiang
 * @Date: 2019-05-31 15:55
 */
@Component
@EnableBinding(Processor.class)
public class Producer {
}
