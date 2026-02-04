package com.rodelindev.SuperMarketApi.service.impl;

import com.rodelindev.SuperMarketApi.model.Sale;
import com.rodelindev.SuperMarketApi.repository.IGenericRepository;
import com.rodelindev.SuperMarketApi.repository.ISaleRepository;
import com.rodelindev.SuperMarketApi.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl extends CrudImpl<Sale, Integer> implements ISaleService {

    private final ISaleRepository repo;

    @Override
    protected IGenericRepository<Sale, Integer> getRepo() {
        return repo;
    }

    @Override
    public Sale save(Sale sale) throws Exception {
        sale.getDetails().forEach(detail -> detail.setSale(sale));
        return repo.save(sale);
    }
}
