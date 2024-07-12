package com.xingcheng.mqTest.work;

import com.rabbitmq.client.*;
import com.xingcheng.util.RabbitMqUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumer1" + new String(body));
            }
        };
        channel.basicConsume("simpleDeclare", true, defaultConsumer);
    }
}
