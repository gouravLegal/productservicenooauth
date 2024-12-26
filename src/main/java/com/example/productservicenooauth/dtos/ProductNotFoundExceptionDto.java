package com.example.productservicenooauth.dtos;

public class ProductNotFoundExceptionDto {
    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    Long errorCode;
    String errorMessage;
}
