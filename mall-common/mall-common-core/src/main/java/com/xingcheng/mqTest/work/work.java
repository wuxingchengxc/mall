package com.xingcheng.mqTest.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xingcheng.util.RabbitMqUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class work {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("simpleDeclare", true, false,false,null);

        for (int i = 0; i < 10; i++) {
            String massage = i+"哈哈";
            channel.basicPublish("", "simpleDeclare", null, massage.getBytes());
        }
        channel.close();
        connection.close();

    }

}
