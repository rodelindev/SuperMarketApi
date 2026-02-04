package com.rodelindev.SuperMarketApi.service.impl;

import com.rodelindev.SuperMarketApi.model.Provider;
import com.rodelindev.SuperMarketApi.repository.IGenericRepository;
import com.rodelindev.SuperMarketApi.repository.IProviderRepository;
import com.rodelindev.SuperMarketApi.service.IProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl extends CrudImpl<Provider, Integer> implements IProviderService {

    private final IProviderRepository repo;

    @Override
    protected IGenericRepository<Provider, Integer> getRepo() {
        return repo;
    }

}
