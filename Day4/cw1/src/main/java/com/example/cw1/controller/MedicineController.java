package com.example.cw1.controller;

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

import com.example.cw1.model.Medicine;
import com.example.cw1.service.MedicineService;

@RestController
@RequestMapping("/api")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
   @PostMapping("/medicine")
    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) {
        Medicine createdMedicine = medicineService.createMedicine(medicine);
        if(createdMedicine != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMedicine);
        else    
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @GetMapping("/medicines")
    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = medicineService.getAllMedicines();
        return medicines;
    }
    @GetMapping("/medicine/{medicineId}")
    public Medicine getMedicineById(@PathVariable("medicineId") int medicineId) {
        Medicine medicine = medicineService.getMedicineById(medicineId);
        return medicine;
    }
}
