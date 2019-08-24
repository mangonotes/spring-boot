package com.example.demo.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_MESSAGE_MASTER")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name="message")
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date")
    private Date createdDate;
    private int status;// 1= message send  2== message received
    @PrePersist
    protected void onInit() {
        createdDate = new Date();
        status = 1;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
