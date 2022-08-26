package com.batch.db2jpa.batch.dto;

import com.batch.db2jpa.dao.entity.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDTO {
    private String name;
    private LocalDateTime createdDate;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
