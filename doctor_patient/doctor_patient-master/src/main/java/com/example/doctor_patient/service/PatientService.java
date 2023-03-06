package com.example.doctor_patient.service;

import com.example.doctor_patient.dao.IPatient;
import com.example.doctor_patient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private IPatient iPatient;
    
   
    public Patient addPatient(Patient patient) {
        return iPatient.save(patient);
    }

    public Patient getById(Integer patientId) {
        return iPatient.findById(patientId).get();
    }

    public List<Patient> findAll() {
        return iPatient.findAll();
    }

	public Patient updatePatient(Integer patientId, Patient patientData) {
		Patient patient1 = iPatient.findById(patientId).get();
		patient1.setPatientName(patientData.getPatientName());
		patient1.setPatientNumber(patientData.getPatientNumber());
		patient1.setGender(patientData.getGender());
		patient1.setPatientDisease(patientData.getPatientDisease());
		patient1.setDoctorId(patientData.getDoctorId());
		return patient1;
	}

	public void deletePatient(Integer patientId) {
		iPatient.deleteById(patientId);
	}
}
