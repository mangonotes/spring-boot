package com.batch.db2jpa.dao.repo;

import com.batch.db2jpa.dao.entity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAll();
}
