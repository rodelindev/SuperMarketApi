package com.rodelindev.SuperMarketApi.service.impl;

import com.rodelindev.SuperMarketApi.model.Role;
import com.rodelindev.SuperMarketApi.repository.IGenericRepository;
import com.rodelindev.SuperMarketApi.repository.IRoleRepository;
import com.rodelindev.SuperMarketApi.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends CrudImpl<Role, Integer> implements IRoleService {

    private final IRoleRepository repo;

    @Override
    protected IGenericRepository<Role, Integer> getRepo() {
        return repo;
    }
}
