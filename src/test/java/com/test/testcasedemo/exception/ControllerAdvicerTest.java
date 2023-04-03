package com.test.testcasedemo.exception;

import com.test.testcasedemo.controller.ProductController;
import com.test.testcasedemo.response.ApiResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

class ControllerAdvicerTest {
  @Autowired
  ControllerAdvicer controllerAdvicer;
    @InjectMocks
    private ProductController productController;
    @Test
    void nullPointerException() {



    }




    @Test()
    void noSuchElementException() {


    }

    @Test
    void illegalArgumentException() {
    }
}