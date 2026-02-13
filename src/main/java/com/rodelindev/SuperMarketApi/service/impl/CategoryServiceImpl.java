package com.rodelindev.SuperMarketApi.service.impl;


import com.rodelindev.SuperMarketApi.model.Category;
import com.rodelindev.SuperMarketApi.repository.ICategoryRepository;
import com.rodelindev.SuperMarketApi.repository.IGenericRepository;
import com.rodelindev.SuperMarketApi.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CrudImpl<Category, Integer> implements ICategoryService {

    private final ICategoryRepository repo;

    @Override
    protected IGenericRepository<Category, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Category> findPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
