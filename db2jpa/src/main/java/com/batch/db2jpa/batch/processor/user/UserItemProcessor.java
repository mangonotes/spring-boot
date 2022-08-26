package com.batch.db2jpa.batch.processor.user;

import com.batch.db2jpa.batch.dto.UserDTO;
import com.batch.db2jpa.dao.entity.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class UserItemProcessor implements ItemProcessor<UserEntity, UserDTO> {
    @Override
    public UserDTO process(UserEntity userEntity) throws Exception {
        UserDTO userDTO = new UserDTO(userEntity.getName(), userEntity.getCreatedDate(), userEntity.getUserType());
        log.info("processing -->> {}", userDTO);
        return userDTO;
    }
}
