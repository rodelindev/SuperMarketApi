package com.rodelindev.SuperMarketApi.service.impl;

import com.rodelindev.SuperMarketApi.model.Client;
import com.rodelindev.SuperMarketApi.repository.IClientRepository;
import com.rodelindev.SuperMarketApi.repository.IGenericRepository;
import com.rodelindev.SuperMarketApi.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends CrudImpl<Client, Integer> implements IClientService {

    private final IClientRepository repo;

    @Override
    protected IGenericRepository<Client, Integer> getRepo() {
        return repo;
    }

}
