
package com.example.demo.messages;
import com.example.demo.service.message.IMessageService;
import com.example.demo.ui.dto.MessageJsonDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;

@Component
public class TestMessageListner implements MessageListener {
    @Autowired
    ObjectMapper objectMapper ;

    @Autowired
    private IMessageService messageService;
    @Override
    public void onMessage(Message message) {
        String json = null;
   if (message instanceof TextMessage)
   {
       TextMessage textMessage =(TextMessage)message;
       try {
           System.out.println(":::text message received:::" +textMessage.getText());
           json= textMessage.getText();

       } catch (JMSException e) {
           e.printStackTrace();
       }
    if (objectMapper.canDeserialize(objectMapper.constructType(MessageJsonDTO.class)))
    {
        try {
            MessageJsonDTO messageJsonDTO=      objectMapper.readValue(json, MessageJsonDTO.class);
            if (messageJsonDTO != null && messageJsonDTO.getId() > 0 && messageJsonDTO.getMessage() != null) {
                messageService.updateStatusData(messageJsonDTO.getId(), 2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   }
    }
}
