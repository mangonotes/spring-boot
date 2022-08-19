package com.example.db2test.dao.entity.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="USER_TB", schema = "DB2INST1")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    private LocalDateTime createdDate;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public UserEntity() {
    }

    public UserEntity(long id, String name, LocalDateTime createdDate, UserType userType) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
