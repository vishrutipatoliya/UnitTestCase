package com.test.testcasedemo.repository;

import com.test.testcasedemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
