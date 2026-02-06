package com.rodelindev.SuperMarketApi.controller;

import com.rodelindev.SuperMarketApi.dto.CategoryDTO;
import com.rodelindev.SuperMarketApi.model.Category;
import com.rodelindev.SuperMarketApi.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService service;
    @Qualifier("categoryMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() throws Exception {
        List<CategoryDTO> list = service.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id) throws Exception {
        Category obj = service.findById(id);

        return ResponseEntity.ok(convertToDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO dto) throws Exception {
        Category obj = service.save(convertToEntity(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(
            @Valid @PathVariable Integer id,
            @RequestBody CategoryDTO dto
    ) throws Exception {
        Category obj = service.update(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    private CategoryDTO convertToDTO(Category entity) {
        return modelMapper.map(entity, CategoryDTO.class);
    }

    private Category convertToEntity(CategoryDTO dto) {
        return modelMapper.map(dto, Category.class);
    }
}
