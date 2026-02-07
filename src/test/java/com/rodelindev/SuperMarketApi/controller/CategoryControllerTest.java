package com.rodelindev.SuperMarketApi.controller;

import com.rodelindev.SuperMarketApi.dto.CategoryDTO;
import com.rodelindev.SuperMarketApi.exception.ModelNotFoundException;
import com.rodelindev.SuperMarketApi.model.Category;
import com.rodelindev.SuperMarketApi.service.ICategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ICategoryService service;

    @MockitoBean
    @Qualifier("categoryMapper")
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    Category CATEGORY_1 = new Category(1, "TV", "Television", true);
    Category CATEGORY_2 = new Category(2, "PSP", "Play Station Portable", true);
    Category CATEGORY_3 = new Category(3, "BOOKS", "Some Books", true);

    @Test
    public void findAllTest() throws Exception {
        when(service.findAll()).thenReturn(Arrays.asList(CATEGORY_1, CATEGORY_2, CATEGORY_3));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void findByIdTest() throws Exception {

        Integer id = 1;
        CategoryDTO expectedDTO = new CategoryDTO();

        expectedDTO.setIdCategory(CATEGORY_1.getIdCategory());
        expectedDTO.setNameofCategory(CATEGORY_1.getName());
        expectedDTO.setDescriptionCategory(CATEGORY_1.getDescription());
        expectedDTO.setEnabledCategory(CATEGORY_1.isEnabled());

        when(service.findById(id)).thenReturn(CATEGORY_1);
        when(modelMapper.map(CATEGORY_1, CategoryDTO.class)).thenReturn(expectedDTO);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/categories/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCategory").value(1))
                .andExpect(jsonPath("$.nameofCategory").value("TV"))
                .andExpect(jsonPath("$.descriptionCategory").value("Television"))
                .andExpect(jsonPath("$.enabledCategory").value(true));
    }

    @Test
    public void saveTest() throws Exception {
        CategoryDTO CATEGORY_DTO_3 = new CategoryDTO(3, "BOOKS", "Some Books", true);

        when(service.save(any())).thenReturn(CATEGORY_3);
        when(modelMapper.map(CATEGORY_3, CategoryDTO.class)).thenReturn(CATEGORY_DTO_3);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CATEGORY_DTO_3)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.enabledCategory", is(true)));
    }

    @Test
    public void updateTest() throws Exception {
        final int ID = 2;

        CategoryDTO CATEGORY_DTO_2 = new CategoryDTO(2, "PSP", "Play Station Portable", true);

        when(service.update(any(), any())).thenReturn(CATEGORY_2);
        when(modelMapper.map(CATEGORY_2, CategoryDTO.class)).thenReturn(CATEGORY_DTO_2);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/v1/categories/{id}", ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CATEGORY_DTO_2)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.enabledCategory", is(true)));
    }

    @Test
    public void updateErrorTest() throws Exception {
        final int ID = 99;

        CategoryDTO CATEGORY_DTO_99 = new CategoryDTO(2, "PSP", "Play Station Portable", true);

        when(service.update(any(), any())).thenThrow(new ModelNotFoundException("ID NOT FOUND" + ID));

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/v1/categories/{id}", ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CATEGORY_DTO_99)))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertInstanceOf(ModelNotFoundException.class, result.getResolvedException()));
    }

    @Test
    public void deleteTest() throws Exception {
        final int ID = 1;

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/categories/{id}", ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteErrorTest() throws Exception {
        final int ID = 99;

        Mockito.doThrow(new ModelNotFoundException("ID NOT FOUND" + ID)).when(service).delete(any());

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/categories/{id}", ID))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertInstanceOf(ModelNotFoundException.class, result.getResolvedException()));
    }


}

