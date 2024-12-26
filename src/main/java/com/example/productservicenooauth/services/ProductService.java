package com.example.productservicenooauth.services;

import com.example.productservicenooauth.exceptions.ProductNotFoundException;
import com.example.productservicenooauth.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product replaceProduct(Long id, Product product);

    Product createProduct(Product product);

    //Creating a createProduct method which returns void in order to test the doNothing() and verify() methods for JUnit test
    void createProductVoid(Product product);
}
