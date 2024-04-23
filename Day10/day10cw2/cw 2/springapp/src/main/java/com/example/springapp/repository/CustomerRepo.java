package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Customer;
import java.util.List;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>{

    @Query("select u from Customer u where u.city=?1")
    List<Customer> findByCity(String city);
    
    @Query("select u from Customer u where u.customerId=?1")
    Customer findAllCustomerId(int id);
    
    @Query("update Customer set pincode=?2 where customerId=?1")
    Customer updateCustomer(int CustomerID,int pincode);
   
    @Query("delete from Customer where customerId=?1")
    void delete(int CustomerID);


}
