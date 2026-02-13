package com.rodelindev.SuperMarketApi.repository;


import com.rodelindev.SuperMarketApi.model.User;

public interface IUserRepository extends IGenericRepository<User, Integer> {
    User findOneByUsername(String username);
}
