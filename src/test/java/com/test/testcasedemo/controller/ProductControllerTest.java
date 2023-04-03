package com.test.testcasedemo.controller;

import com.test.testcasedemo.dto.ProductResponseDTO;
import com.test.testcasedemo.dto.ProductRequestDTO;
import com.test.testcasedemo.response.ApiResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest extends AbstractControllerTest {

    @Autowired
    @InjectMocks
    ProductController productController;


//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void addProduct() {

//        Request
        ProductRequestDTO productReuestDTO = new ProductRequestDTO("Mouse", 500L, 5L, "lenovo");

//        Mock
        ProductResponseDTO productResponseDTO = new ProductResponseDTO(1, "Mouse", 500L, 5L, "lenovo");
        ResponseEntity<ApiResponse> customeResponse = new ResponseEntity<>(new ApiResponse(productResponseDTO, "product added successfully", HttpStatus.OK), HttpStatus.OK);

//        Mocking
        when(productService.save(Mockito.any(ProductRequestDTO.class))).thenReturn(productResponseDTO);

//        Test
        ResponseEntity<ApiResponse> expectedResponse = productController.addProduct(productReuestDTO);

        //Assertion
        verify(productService, times(1)).save(Mockito.any(ProductRequestDTO.class));
        assertEquals(customeResponse, expectedResponse);
        System.out.println("customeResponse = " + customeResponse);

    }

    @Test
    void displayAll() {
        List<ProductResponseDTO> mockProduct = new ArrayList<>();
        mockProduct.add(new ProductResponseDTO(1, "Mouse", 500L, 5L, "lenovo"));
        mockProduct.add(new ProductResponseDTO(8, "keyboard", 1000L, 3L, "HP"));
        ResponseEntity<ApiResponse> customeResponse = new ResponseEntity<>(new ApiResponse(mockProduct, "display all product", HttpStatus.OK), HttpStatus.OK);
        when(productService.findAll()).thenReturn(mockProduct);
        ResponseEntity<ApiResponse> expectedResponse = productController.displayAll();

        verify(productService, Mockito.times(1)).findAll();
        assertEquals(customeResponse, expectedResponse);
    }

    @Test
    void deleteProduct() {
        int id = 6;
        ResponseEntity<ApiResponse> customeResponse = new ResponseEntity<>(new ApiResponse(Collections.emptyMap(), "delete successfully", HttpStatus.OK), HttpStatus.OK);
        ResponseEntity<ApiResponse> expectedResponse = productController.deleteProduct(id);
        verify(productService, times(1)).delete(id);
        assertEquals(customeResponse, expectedResponse);
    }

    @Test
    void getProduct() {
        int id = 6;
        ProductResponseDTO productResponseDTO = new ProductResponseDTO(id, "Mouse", 500L, 5L, "lenovo");

        ResponseEntity<ApiResponse> customeResponse = new ResponseEntity<>(new ApiResponse(productResponseDTO, "product is available", HttpStatus.OK), HttpStatus.OK);
        when(productService.findProduct(id)).thenReturn(productResponseDTO);
        ResponseEntity<ApiResponse> expectedResponse = productController.getProduct(id);

        verify(productService, Mockito.times(1)).findProduct(id);
        assertEquals(customeResponse, expectedResponse);

    }

    @Test
    void updateProduct() {
        int id = 6;
        ProductRequestDTO productReuestDTO = new ProductRequestDTO("Mouse", 500L, 5L, "lenovo");

        ProductResponseDTO productResponseDTO = new ProductResponseDTO(id, "keyboard", 500L, 5L, "lenovo");

        ResponseEntity<ApiResponse> customResponse = new ResponseEntity<>(new ApiResponse(productResponseDTO, "update successfully", HttpStatus.OK), HttpStatus.OK);
        when(productService.update(productReuestDTO, id)).thenReturn(productResponseDTO);
        ResponseEntity<ApiResponse> expectedResponse = productController.updateProduct(productReuestDTO, id);
        verify(productService, Mockito.times(1)).update(productReuestDTO, id);
        assertEquals(customResponse,expectedResponse);
    }
}