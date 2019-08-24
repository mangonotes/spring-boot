package com.example.demo.service.message;

import com.example.demo.dao.entity.MessageEntity;
import com.example.demo.dao.repository.MessageRepository;
import com.example.demo.messages.IMessageSender;
import com.example.demo.ui.dto.MessageJsonDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MessageService implements  IMessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private IMessageSender messageSender;
    @Autowired
    ObjectMapper objectMapper ;
    @Override
    public int saveDataAndSend(String message) {
        MessageEntity entity = new MessageEntity();
        entity.setMessage(message);

        MessageEntity savedEntity= messageRepository.save(entity);
        MessageJsonDTO messageJsonDTO = new MessageJsonDTO(savedEntity.getId(), savedEntity.getMessage());
        try {
            messageSender.send(objectMapper.writeValueAsString(messageJsonDTO));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return savedEntity.getId();
    }

    @Override
    public boolean isReceivedResponse(int id) {
       Optional<MessageEntity> entity=  messageRepository.findById(id);
       boolean result = false;
       entity.filter(e -> e.getStatus() > 1);
       if (entity.isPresent())
       {
           return true;
       }
       return  false;
    }
    @Transactional
    @Override
    public String updateStatusData(int id, int status) {
        Optional<MessageEntity> entity=  messageRepository.findById(id);
        entity.ifPresent(e -> {
            e.setStatus(status);
            messageRepository.save(e);
        });
        return entity.get().getMessage();
    }
}
