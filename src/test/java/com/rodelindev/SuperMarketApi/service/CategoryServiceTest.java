package com.rodelindev.SuperMarketApi.service;


import com.rodelindev.SuperMarketApi.model.Category;
import com.rodelindev.SuperMarketApi.repository.ICategoryRepository;
import com.rodelindev.SuperMarketApi.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {

    @MockitoBean
    private ICategoryRepository repository;

    @MockitoBean
    private ICategoryService service;

    private Category CATEGORY_1;
    private Category CATEGORY_2;
    private Category CATEGORY_3;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.service = new CategoryServiceImpl(repository);
        CATEGORY_1 = new Category(1, "TV", "Television", true);
        CATEGORY_2 = new Category(2, "PSP", "Play Station Portable", true);
        CATEGORY_3 = new Category(3, "BOOKS", "Some Books", true);

        Mockito.when(repository.findAll()).thenReturn(List.of(CATEGORY_1, CATEGORY_2, CATEGORY_3));
        Mockito.when(repository.findById(1)).thenReturn(Optional.ofNullable(CATEGORY_1));
    }

    @Test
    void findAllTest() throws Exception {
        //Mockito.when(repository.findAll()).thenReturn(List.of(CATEGORY_1, CATEGORY_2, CATEGORY_3));
        List<Category> response = service.findAll();

        //assertNotNull(response);
        //assertTrue(response.isEmpty());
        assertFalse(response.isEmpty());
    }

    @Test
    void findByIdTest() throws Exception {
        //Mockito.when(repository.findById(1)).thenReturn(Optional.ofNullable(CATEGORY_1));
        Category response = service.findById(1);

        assertNotNull(response);
        assertEquals("TV", response.getName());
        assertInstanceOf(Category.class, response);
    }

    @Test
    void saveTest() throws Exception {
        Category newCategory = new Category(null, "Laptop", "Portable computer", true);
        Category savedCategory = new Category(4, "Laptop", "Portable computer", true);

        Mockito.when(repository.save(newCategory)).thenReturn(savedCategory);

        Category response = service.save(newCategory);

        assertNotNull(response);
        assertEquals(4, response.getIdCategory());
        assertEquals("Laptop", response.getName());

    }

    @Test
    void updateTest() throws Exception {
        Category updateCategory = new Category(1, "Smart TV", "Smart Television", true);

        Mockito.when(repository.save(updateCategory)).thenReturn(updateCategory);

        Category response = service.update(updateCategory.getIdCategory(), updateCategory);

        assertNotNull(response);
        assertEquals(1, response.getIdCategory());
        assertEquals("Smart TV", response.getName());
    }

    @Test
    void deleteTest() throws Exception {
        final  int ID = 1;

        //service.delete(ID);
        //service.delete(ID);
        //service.delete(ID);

        //verify(repository, times(1)).deleteById(ID);
        //verify(repository, atLeast(2)).deleteById(ID);
        //verify(repository, atMost(2)).deleteById(ID);
        verify(repository, never()).deleteById(ID);
    }
}
