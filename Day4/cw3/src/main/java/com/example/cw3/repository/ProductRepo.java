
package com.example.cw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cw3.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
    
}