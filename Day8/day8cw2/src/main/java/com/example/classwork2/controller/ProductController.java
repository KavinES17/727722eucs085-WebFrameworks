package com.example.classwork2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.classwork2.model.Product;
import com.example.classwork2.service.ProductService;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService)
    {
        this.productService=productService;
    }

     @PostMapping("/product")
    public ResponseEntity<Product> postMethod(@RequestBody Product product) {
        if(productService.saveMethod(product) == true)
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        return new ResponseEntity<>(product,HttpStatus.INTERNAL_SERVER_ERROR);

    }

     @GetMapping("/product/distinct/startwith/{name}")
    public ResponseEntity<List<Product>> getUsingStartWith(@PathVariable("name") String name) {
        List<Product> list=productService.nameStartWith(name);
        if(list.size() == 0)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/product/distinct/endwith/{name}")
    public ResponseEntity<List<Product>> getUsingEndWith(@PathVariable("name") String name) {
        List<Product> list=productService.nameEndWith(name);
        if(list.size() == 0)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/product/sortBy/price")
    public ResponseEntity<List<Product>> sortMethod() {
        List<Product> list=productService.sortByPrice();
        if(list.size() == 0)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
