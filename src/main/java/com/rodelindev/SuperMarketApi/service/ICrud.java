package com.rodelindev.SuperMarketApi.service;

import java.util.List;

public interface ICrud<T, ID> {
    List<T> findAll() throws Exception;
    T save(T t) throws Exception;
    T update(ID id, T t) throws Exception;
    T findById(ID id) throws Exception;
    void delete(ID id) throws Exception;
}
