package com.example.db2test.service;

import com.example.db2test.dao.entity.entity.UserEntity;
import com.example.db2test.dao.repo.UserRepository;
import com.example.db2test.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserConversionService userConversionService;
    private final UserRepository userRepository;

    public UserService(UserConversionService userConversionService, UserRepository userRepository) {
        this.userConversionService = userConversionService;
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUser() {
        List<UserDTO> userDTOList = userRepository.findAll()
                .stream()
                .map(userConversionService.convert())
                .collect(Collectors.toList());
        return userDTOList;
    }
}
