package com.test.testcasedemo.dto;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor

public class ProductRequestDTO {
    @NotNull(message = "productName null not accepted")
    String productName;
    @NotNull(message = "price null not accepted")
    Long price;
    @NotNull(message = "qty null not accepted")
    Long qty;
    @NotNull(message = "brand null not accepted")
    String brand;
}
