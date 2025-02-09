package org.example.clinicapostpandemiademo.repository;

import org.example.clinicapostpandemiademo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
