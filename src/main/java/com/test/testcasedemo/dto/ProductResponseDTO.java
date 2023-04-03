package com.test.testcasedemo.dto;

import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductResponseDTO {
    int id;
    String productName;
    Long price;
    Long qty;
    String brand;


}
