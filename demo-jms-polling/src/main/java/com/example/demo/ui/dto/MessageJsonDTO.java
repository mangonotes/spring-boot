package com.example.demo.ui.dto;

import java.io.Serializable;
import java.util.Date;

public class MessageJsonDTO implements Serializable {
    private int id;
    private String message;
    private Date createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public MessageJsonDTO(int id, String message, Date createdDate) {
        this.id = id;
        this.message = message;
        this.createdDate = createdDate;
    }
    public  MessageJsonDTO(int id , String message)
    {
        this(id,message, new Date());
    }
    public MessageJsonDTO()
    {

    }

}
