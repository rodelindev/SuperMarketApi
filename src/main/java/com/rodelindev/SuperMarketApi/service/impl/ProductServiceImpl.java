package com.rodelindev.SuperMarketApi.service.impl;

import com.rodelindev.SuperMarketApi.model.Product;
import com.rodelindev.SuperMarketApi.repository.IGenericRepository;
import com.rodelindev.SuperMarketApi.repository.IProductRepository;
import com.rodelindev.SuperMarketApi.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CrudImpl<Product, Integer> implements IProductService {

    private final IProductRepository repo;

    @Override
    protected IGenericRepository<Product, Integer> getRepo() {
        return repo;
    }
}
