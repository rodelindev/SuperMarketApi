package com.rodelindev.SuperMarketApi.service;

import com.rodelindev.SuperMarketApi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends ICrud<Product, Integer> {
    Page<Product> findPage(Pageable pageable);
}
