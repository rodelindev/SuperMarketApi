package com.rodelindev.SuperMarketApi.config;

import com.rodelindev.SuperMarketApi.dto.CategoryDTO;
import com.rodelindev.SuperMarketApi.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean("categoryMapper")
    public ModelMapper categoryMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //LECTURA
        modelMapper.createTypeMap(Category.class, CategoryDTO.class)
                .addMapping(Category::getName, CategoryDTO::setNameofCategory);

        //ESCRITURA
        modelMapper.createTypeMap(CategoryDTO.class, Category.class)
                .addMapping(CategoryDTO::getNameofCategory, Category::setName);

        return modelMapper;
    }
}
