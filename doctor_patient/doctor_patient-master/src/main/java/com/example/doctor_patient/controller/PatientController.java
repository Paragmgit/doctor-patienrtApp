package com.example.doctor_patient.controller;

import com.example.doctor_patient.dao.IDoctor;
import com.example.doctor_patient.model.Doctor;
import com.example.doctor_patient.model.Patient;
import com.example.doctor_patient.service.PatientService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    
    @Autowired
    private IDoctor idoctor;
    
    
    @PostMapping("/add-patient")
    public ResponseEntity<String> createPatient(@RequestBody String patientData){
    	Patient patient = setPatient(patientData);
    	patientService.addPatient(patient);
    	return new ResponseEntity<String>("succefully added",HttpStatus.CREATED);
    }
    
    private Patient setPatient(String patientData) {
		JSONObject jsonObject = new JSONObject(patientData);
		Patient patient = new Patient();
		patient.setPatientName(jsonObject.getString("patientName"));
		patient.setPatientNumber(jsonObject.getString("patientNumber"));
		patient.setPatientDisease(jsonObject.getString("patientDisease"));
		patient.setGender(jsonObject.getString("gender"));
	    Doctor doctor = idoctor.findById(jsonObject.getInt("doctorId")).get();
	    patient.setDoctorId(doctor);
		
		return patient;
	}

	@GetMapping("/patient/{patientId}")
    public Patient getById(@PathVariable Integer patientId){
        return patientService.getById(patientId);
    }
    @GetMapping("/all-patient")
    public List<Patient> findAllPatients(){
        return patientService.findAll();
    }
    
    @PutMapping("/update-patient/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer patientId,@RequestBody Patient patientData){
    	Patient patient1 = patientService.updatePatient(patientId, patientData);
    	return new ResponseEntity<Patient>(patient1,HttpStatus.ACCEPTED);
        
    }
    
    @DeleteMapping("/delete-patient/{patientId}")
    public void deletePatient(@PathVariable Integer patientId) {
    	patientService.deletePatient(patientId);
    }

}
