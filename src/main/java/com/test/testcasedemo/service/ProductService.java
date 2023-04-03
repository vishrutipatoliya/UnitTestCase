package com.test.testcasedemo.service;

import com.test.testcasedemo.dto.ProductResponseDTO;
import com.test.testcasedemo.dto.ProductRequestDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO save(ProductRequestDTO productReuestDTO);
    List<ProductResponseDTO> findAll();
    ProductResponseDTO findProduct(int id);
    void delete(int id);
    ProductResponseDTO update(ProductRequestDTO productReuestDTO , int id);


}
