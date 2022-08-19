package com.example.db2test.service;


import com.example.db2test.dao.entity.entity.UserEntity;
import com.example.db2test.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserConversionService {

    public Function<UserEntity, UserDTO> convert(){
        return user -> new UserDTO(user.getName(), user.getUserType(), user.getId(), user.getCreatedDate());
    }
}
