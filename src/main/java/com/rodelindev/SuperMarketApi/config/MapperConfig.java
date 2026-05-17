package com.rodelindev.SuperMarketApi.config;

import com.rodelindev.SuperMarketApi.dto.CategoryDTO;
import com.rodelindev.SuperMarketApi.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {

    @Primary
    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean("categoryMapper")
    public ModelMapper categoryMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //Read
        modelMapper.createTypeMap(Category.class, CategoryDTO.class)
                .addMapping(Category::getName, CategoryDTO::setNameofCategory);

        //Write
        modelMapper.createTypeMap(CategoryDTO.class, Category.class)
                .addMapping(CategoryDTO::getNameofCategory, Category::setName);

        return modelMapper;
    }
}
