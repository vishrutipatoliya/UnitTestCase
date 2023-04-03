package com.test.testcasedemo.controller;

import com.test.testcasedemo.dto.ProductResponseDTO;
import com.test.testcasedemo.dto.ProductRequestDTO;
import com.test.testcasedemo.response.ApiResponse;
import com.test.testcasedemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@Validated
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductRequestDTO productReuestDTO) {
        ProductResponseDTO productResponseDTO = this.productService.save(productReuestDTO);
        return new ResponseEntity<>(new ApiResponse(productResponseDTO, "product added successfully", HttpStatus.OK), HttpStatus.OK);

    }

    @GetMapping("/display")
    public ResponseEntity<ApiResponse> displayAll() {
        List<ProductResponseDTO> productResponseDTOList = productService.findAll();
        System.out.println("product" + productResponseDTOList);
        return new ResponseEntity<>(new ApiResponse(productResponseDTOList, "display all product", HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return new ResponseEntity<>(new ApiResponse(Collections.emptyMap(), "delete successfully", HttpStatus.OK), HttpStatus.OK);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getProduct(@PathVariable("id") int id) {
        ProductResponseDTO product = productService.findProduct(id);
        return new ResponseEntity<>(new ApiResponse(product, "product is available", HttpStatus.OK), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody @Valid ProductRequestDTO requestDto, @PathVariable("id") int id) {
       ProductResponseDTO productResponseDTO = this.productService.update(requestDto,id);
       return new  ResponseEntity<>(new ApiResponse(productResponseDTO,"update successfully",HttpStatus.OK),HttpStatus.OK);

    }


}
