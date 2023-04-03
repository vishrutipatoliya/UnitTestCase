package com.test.testcasedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "product_name")
    String productName;
    @Column(name = "price")
    Long price;
    @Column(name = "qty")
    Long qty;
    @Column(name = "brand")
    String brand;

}
