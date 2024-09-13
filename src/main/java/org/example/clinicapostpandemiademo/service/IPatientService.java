package org.example.clinicapostpandemiademo.service;

import org.example.clinicapostpandemiademo.entity.Patient;

import java.util.List;

public interface IPatientService {

    Patient getPatient(long id);
    List<Patient> getAllPatients();
    Patient savePatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatient(Patient patient);
    void deletePatientById(long id);
}
