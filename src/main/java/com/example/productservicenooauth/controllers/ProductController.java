package com.example.productservicenooauth.controllers;

import com.example.productservicenooauth.exceptions.ProductNotFoundException;
import com.example.productservicenooauth.models.Product;
import com.example.productservicenooauth.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    // Uncomment the below method if you want to inject FakeStoreProductService instead of SelfProductService (to test Redis cache implementation)
    public ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }

    // Uncomment the below method if you want to inject FakeStoreProductService instead of SelfProductService (to test Redis cache implementation)
    /*public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>In getProductById Controller<<<<<<<<<<<<<<<<<<");
        Product product = productService.getProductById(id);
        ResponseEntity<Product> responseEntityProduct;

        //We cannot check for null product and return a detailed error message as part of the response as it needs to return a Product which does not have these details.
        //We therefore throw an exception in this case which gets handled by the filter (@ControllerAdvice) and changes the response type before sending the response to the client
        /*if(product == null) {
            responseEntityProduct = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            responseEntityProduct = new ResponseEntity<>(product, HttpStatus.OK);
        }*/
        responseEntityProduct = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntityProduct;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

}
