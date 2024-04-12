//Controller
package com.example.cw3.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.cw3.model.Product;
import com.example.cw3.service.ProductService;
 
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/product/add")
        public ResponseEntity<Product> createProduct(@RequestBody Product Product) {
            Product createdProduct = productService.createProduct(Product);
            if(createdProduct != null)
                return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
            else    
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        @GetMapping("/product")
        public List<Product> getAllProducts() {
            List<Product> Products = productService.getAllProducts();
            return Products;
        }
        @GetMapping("/product/{productId}")
        public Product getProductById(@PathVariable("productId") int productId) {
            Product Product = productService.getProductById(productId);
            return Product;
        }
}