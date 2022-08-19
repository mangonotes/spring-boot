package com.example.db2test.dto;

import com.example.db2test.dao.entity.entity.UserType;
import java.time.LocalDateTime;

public class UserDTO {
    private String name;

    public UserDTO(String name, UserType userType, Long id, LocalDateTime createdDate) {
        this.name = name;
        this.userType = userType;
        this.id = id;
        this.createdDate = createdDate;
    }

    private UserType userType;
    private Long id;
    private LocalDateTime createdDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
