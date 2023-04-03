package com.test.testcasedemo.exception;
import com.test.testcasedemo.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.NoSuchElementException;


@ControllerAdvice
@ResponseBody
public class ControllerAdvicer {
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ApiResponse> nullPointerException() {

        return new ResponseEntity<>(new ApiResponse(Collections.emptyMap(), "null value not allowed", HttpStatus.NOT_ACCEPTABLE), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<ApiResponse> noSuchElementException() {

        return new ResponseEntity<>(new ApiResponse(Collections.emptyMap(), "product is not available in database ", HttpStatus.NOT_ACCEPTABLE), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> illegalArgumentException() {

        return new ResponseEntity<>(new ApiResponse(Collections.emptyMap(), "product is not available in database ", HttpStatus.NOT_ACCEPTABLE), HttpStatus.NOT_ACCEPTABLE);
    }


}
