package com.example.productservicenooauth.exceptions;

public class ProductNotFoundException extends Exception {
    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    private Long errorCode;

    public ProductNotFoundException(Long errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
