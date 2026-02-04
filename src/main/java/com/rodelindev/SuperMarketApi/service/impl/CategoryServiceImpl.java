package com.rodelindev.SuperMarketApi.service.impl;


import com.rodelindev.SuperMarketApi.model.Category;
import com.rodelindev.SuperMarketApi.repository.ICategoryRepository;
import com.rodelindev.SuperMarketApi.repository.IGenericRepository;
import com.rodelindev.SuperMarketApi.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CrudImpl<Category, Integer> implements ICategoryService {

    private final ICategoryRepository repo;

    @Override
    protected IGenericRepository<Category, Integer> getRepo() {
        return repo;
    }
}
