package com.test.testcasedemo.service;

import com.test.testcasedemo.dto.ProductResponseDTO;
import com.test.testcasedemo.dto.ProductRequestDTO;
import com.test.testcasedemo.entity.Product;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceimplTest extends AbstractServiceTest {
    @Autowired
    @InjectMocks
    private ProductServiceimpl productServiceimpl;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void save() {
        //        Request
        ProductRequestDTO productReuestDTO = new ProductRequestDTO("sandal", 1200L, 10L, "puma");
        //mocking
        when(productRepo.save(Mockito.any(Product.class))).thenReturn(new Product());
        //test
        productServiceimpl.save(productReuestDTO);

        verify(productRepo, times(1)).save(Mockito.any(Product.class));
//        assertEquals(0, 0);
    }

//    @Test
//    void searchById() {
//        int id = 6;
//
//        when(productRepo.findById(id)).thenReturn(new Product());
//
//
//
//    }

    @Test
    void findAll() {
        //Mock
        List<Product> mockProduct = new ArrayList<>();
        mockProduct.add(new Product(1, "Mouse", 500L, 5L, "lenovo"));
        mockProduct.add(new Product(8, "keyboard", 1000L, 3L, "HP"));
        //mocking
        when(productRepo.findAll()).thenReturn(mockProduct);
        //testing
        productServiceimpl.findAll();
        verify(productRepo, times(1)).findAll();


    }

    @Test
    void mapToResponseProductDto() {
    }

    @Test
    void findProduct() {
        int id = 6;
        ProductResponseDTO productResponseDTO = new ProductResponseDTO(1, "Mouse", 500L, 5L, "lenovo");
        when(productRepo.findById(id)).thenReturn(Optional.of(new Product(1, "Mouse", 500L, 5L, "lenovo")));
        ProductResponseDTO expectedResponse = productServiceimpl.findProduct(id);
        verify(productRepo, times(1)).findById(id);
        assertEquals(productResponseDTO, expectedResponse);

    }

    @Test
    void delete() {
        int id = 6;
        when(productRepo.findById(id)).thenReturn(Optional.of(new Product(1, "Mouse", 500L, 5L, "lenovo")));
        Mockito.doNothing().when(productRepo).deleteById(id);
        productServiceimpl.delete(id);
        verify(productRepo, times(1)).deleteById(id);
    }

    @Test
    void update() {
        int id = 6;
        ProductRequestDTO productReuestDTO = new ProductRequestDTO("Mouse", 500L, 5L, "lenovo");
        ProductResponseDTO productResponseDTO = new ProductResponseDTO(1, "Mouse", 500L, 5L, "lenovo");
        Product product = new Product(1, "Mouse", 500L, 5L, "lenovo");
        when(productRepo.findById(id)).thenReturn(Optional.of(product));
        when(productRepo.save(product)).thenReturn(product);
        ProductResponseDTO expectedResponse = productServiceimpl.update(productReuestDTO, id);

        verify(productRepo,times(1)).findById(id);
        verify(productRepo,times(1)).save(product);
    }
}