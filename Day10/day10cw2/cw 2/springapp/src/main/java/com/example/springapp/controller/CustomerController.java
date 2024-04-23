package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.Customer;
import com.example.springapp.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService ser;

    @PostMapping("/api/customer")
    public ResponseEntity<Customer> post(@RequestBody Customer customer) {
        if (ser.post(customer)) {
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/customer/bycity/{city}")
    public ResponseEntity<List<Customer>> getAllbyFiltering(@RequestParam("city") String city) {
        List<Customer> li = ser.getAllCustomerbyCity(city);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/customer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> li = ser.getAllCustomer();
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/customer/{customerId}")
    public ResponseEntity<Customer> getAllCustomerByCustomerId(@PathVariable("customerId") int customerId) {
        Customer li = ser.getAllCustomerById(customerId);
        if (li!=null) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    @PutMapping("/api/customer/{customerId}/{pincode}")
    public ResponseEntity<Customer> updaCustomerByPincode(@PathVariable("customerId") int customerId,@PathVariable("pincode") int pincode) {
        Customer li = ser.updaCustomerPincode(customerId,pincode);
        if (li!=null) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/api/customer/{customerId}")
    public ResponseEntity<String> updaCustomerByPincode(@PathVariable("customerId") int customerId) {
        
        Customer li = ser.getAllCustomerById(customerId);
        if (li!=null) {
            ser.deleteByCustomerID(customerId);
            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   

    
}
