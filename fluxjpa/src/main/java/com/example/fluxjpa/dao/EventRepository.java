package com.example.fluxjpa.dao;

import com.example.fluxjpa.dao.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {

}
