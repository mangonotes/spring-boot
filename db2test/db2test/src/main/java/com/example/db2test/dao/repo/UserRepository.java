package com.example.db2test.dao.repo;

import com.example.db2test.dao.entity.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository  extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();
}
