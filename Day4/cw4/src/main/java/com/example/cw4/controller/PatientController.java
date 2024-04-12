package com.example.cw4.controller;
 
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
 
import com.example.cw4.model.Patient;
import com.example.cw4.service.PatientService;
 
@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("/patient")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient Patient) {
        Patient createdPatient = patientService.createPatient(Patient);
        if(createdPatient != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
        else    
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @GetMapping("/patient")
    public List<Patient> getAllPatients() {
        List<Patient> Patients = patientService.getAllPatients();
        return Patients;
    }
    @GetMapping("/patient/{patientId}")
    public Patient getPatientById(@PathVariable("patientId") int PatientId) {
        Patient Patient = patientService.getPatientById(PatientId);
        return Patient;
    }
}