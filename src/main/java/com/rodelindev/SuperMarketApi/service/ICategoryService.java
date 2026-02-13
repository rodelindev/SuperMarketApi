package com.rodelindev.SuperMarketApi.service;


import com.rodelindev.SuperMarketApi.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends ICrud<Category, Integer>{
    Page<Category> findPage(Pageable pageable);
}
