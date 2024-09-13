package org.example.clinicapostpandemiademo.service;

import org.example.clinicapostpandemiademo.entity.Patient;
import org.example.clinicapostpandemiademo.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("patientServiceimpl")
public class PatientServiceimpl implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;


    @Override
    public Patient getPatient(long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public void deletePatientById(long id) {
        patientRepository.deleteById(id);
    }
}
