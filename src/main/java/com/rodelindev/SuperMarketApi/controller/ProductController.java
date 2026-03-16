package com.rodelindev.SuperMarketApi.controller;

import com.rodelindev.SuperMarketApi.dto.ProductDTO;
import com.rodelindev.SuperMarketApi.model.Product;
import com.rodelindev.SuperMarketApi.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() throws Exception {
        List<ProductDTO> list = service.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/list")
    public ResponseEntity<PagedModel<ProductDTO>> findPage(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageResult = service.findPage(PageRequest.of(page, size)).map(this::convertToDTO);
        var pagedModel = new PagedModel<>(pageResult);

        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) throws Exception {
        Product obj = service.findById(id);

        return ResponseEntity.ok(convertToDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO dto) throws Exception {
        Product obj = service.save(convertToEntity(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(
            @Valid @PathVariable Integer id,
            @RequestBody ProductDTO dto
    ) throws Exception {
        //dto.setIdProduct(id);
        Product obj = service.update(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    private ProductDTO convertToDTO(Product entity) {
        return modelMapper.map(entity, ProductDTO.class);
    }

    private Product convertToEntity(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

}
