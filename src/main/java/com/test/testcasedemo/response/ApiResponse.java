package com.test.testcasedemo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.http.HttpStatus;
@Getter
//@Setter
//@RequiredArgsConstructor
@EqualsAndHashCode
//@ToString
public class ApiResponse {
    private int status;
    private String message;
    private Object data;
    @JsonIgnore
    private HttpStatus httpStatus;

    public ApiResponse( Object data, String message,HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.message = message;
        this.data = data;
    }
}
