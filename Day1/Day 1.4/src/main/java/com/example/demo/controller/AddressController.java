package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Address;
@RestController
public class AddressController {
    @GetMapping("/address")
    public Address addressobject(){
        Address obj = new Address();
        obj.setName("Kavin");
        obj.setDoorNo(123);
        obj.setStreetName("Main St");
        obj.setPincode(600123);
        obj.setArea("k area");
        obj.setDistrict("Chennai");
        obj.setState("Tamil Nadu");
        obj.setCountry("India");
        return obj;
    }
}
