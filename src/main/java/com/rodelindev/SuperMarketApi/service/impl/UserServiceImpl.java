package com.rodelindev.SuperMarketApi.service.impl;

import com.rodelindev.SuperMarketApi.model.User;
import com.rodelindev.SuperMarketApi.repository.IGenericRepository;
import com.rodelindev.SuperMarketApi.repository.IUserRepository;
import com.rodelindev.SuperMarketApi.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CrudImpl<User, Integer> implements IUserService {

    private final IUserRepository repo;

    @Override
    protected IGenericRepository<User, Integer> getRepo() {
        return repo;
    }
}
