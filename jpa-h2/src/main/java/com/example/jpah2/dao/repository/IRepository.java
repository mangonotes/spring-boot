package com.example.jpah2.dao.repository;

public interface IRepository<ENTITY> {
    public ENTITY save(ENTITY entity);
}
