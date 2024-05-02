package com.example.cw3.controller;


import com.example.cw3.model.Product;
import com.example.cw3.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService ProductService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/products; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                "N/A", HttpStatus.OK.value(), "List of Products", "N/A");
        List<Product> Products = ProductService.getAllProducts();
        return ResponseEntity.ok(Products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/products/{}; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                id, HttpStatus.OK.value(), "Product details", "N/A");
        Product Product = ProductService.getProductById(id);
        return ResponseEntity.ok(Product);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product Product) {
        logger.info("FINISHED PROCESSING : METHOD=POST; REQUESTURI=/products; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                Product, HttpStatus.CREATED.value(), "Product added successfully", "N/A");
        Product savedProduct = ProductService.addProduct(Product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}