package com.example.demo.messages;

import javax.jms.Message;

public interface IMessageSender {
    void send(String message);
}
