package com.example.day5cw1.service;

import org.springframework.stereotype.Service;

import com.example.day5cw1.model.Product;
import com.example.day5cw1.repository.ProductRepo;

@Service
public class ProductService {
    public ProductRepo productRepo;
    public ProductService(ProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean saveProduct(Product product)
    {
        try
        {
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,Product product)
    {
        if(this.getProductById(id)==null)
        {
            return false;
        }
        try{
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteProduct(int id)
    {
        if(this.getProductById(id) == null)
        {
            return false;
        }
        productRepo.deleteById(id);
        return true;
    }
    public Product getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
