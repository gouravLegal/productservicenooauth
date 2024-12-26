package com.example.productservicenooauth.exceptionhandlers;

import com.example.productservicenooauth.dtos.ProductNotFoundExceptionDto;
import com.example.productservicenooauth.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setErrorCode(productNotFoundException.getErrorCode());
        productNotFoundExceptionDto.setErrorMessage(productNotFoundException.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto, HttpStatus.NOT_FOUND);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    ResponseEntity<ProductNotFoundExceptionDto> handleNullException(ProductNotFoundException productNotFoundException) {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setErrorCode(productNotFoundException.getErrorCode());
        productNotFoundExceptionDto.setErrorMessage(productNotFoundException.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto, HttpStatus.NOT_FOUND);
    }

}
