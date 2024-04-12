package com.example.cw3.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.cw3.model.Product;
import com.example.cw3.repository.ProductRepo;
 
@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
 
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
    public List<Product> getAllProducts() {
        return (List<Product>) productRepo.findAll();
    }
    public Product getProductById(int productId) {
        return productRepo.findById(productId).orElse(null);
    }
}