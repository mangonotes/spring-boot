package com.example.demo.service.message;

public interface IMessageService {
    int saveDataAndSend(String message);
    boolean isReceivedResponse(int id);
    String  updateStatusData(int id, int status);
}
