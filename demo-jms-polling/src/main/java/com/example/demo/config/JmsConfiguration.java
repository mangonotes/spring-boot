package com.example.demo.config;

import com.example.demo.messages.TestMessageListner;
import com.example.demo.ui.dto.MessageJsonDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Message;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmsConfiguration {
    @Value("${spring.activemq.broker-url}")
    private  String jmsBrockerurl;
    @Value("${demo.activemq.queue-name}")
    private String jmsQueueName;
    @Autowired
    TestMessageListner testMessageListner;
    @Autowired
    ObjectMapper objectMapper ;

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(jmsBrockerurl);

        return connectionFactory;
    }
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }
    @Bean
    DefaultMessageListenerContainer createDefaultMessageListenerContainer()
    {
        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(connectionFactory());
        defaultMessageListenerContainer.setDestinationName(jmsQueueName);
        defaultMessageListenerContainer.setMessageListener(testMessageListner);
        defaultMessageListenerContainer.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        return  defaultMessageListenerContainer;

    }

    @PostConstruct
    private void postTesting()
    {
        Map<String, String> messageTest = new HashMap<String, String>();
        System.out.println("jmsbroker url" + jmsBrockerurl);
        System.out.println("jms template" + jmsTemplate());
        messageTest.put("testing", "test");
         String json = null;
        try {
            json = objectMapper.writeValueAsString(messageTest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        final String message = json;
        jmsTemplate().send(jmsQueueName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
