package com.rodelindev.SuperMarketApi.service.impl;

import com.rodelindev.SuperMarketApi.model.Ingress;
import com.rodelindev.SuperMarketApi.repository.IGenericRepository;
import com.rodelindev.SuperMarketApi.repository.IngressRepository;
import com.rodelindev.SuperMarketApi.service.IngressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngressServiceImpl extends CrudImpl<Ingress, Integer> implements IngressService {

    private final IngressRepository repo;

    @Override
    protected IGenericRepository<Ingress, Integer> getRepo() {
        return repo;
    }
}
