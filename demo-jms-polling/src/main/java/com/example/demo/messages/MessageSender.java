package com.example.demo.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.awt.image.ImageConsumer;
@Component
public class MessageSender implements IMessageSender {
    @Value("${demo.activemq.queue-name}")
    private String jmsQueueName;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Override
    public void send(String message) {
        jmsTemplate.send(jmsQueueName,  session -> {
         return  session.createTextMessage(message);
               }
       );


    }
}
