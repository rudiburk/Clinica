package org.example.clinicapostpandemiademo;

import org.example.clinicapostpandemiademo.entity.Patient;
import org.example.clinicapostpandemiademo.service.IPatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


public class PatientServicesTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(PatientServicesTest.class);

    public static Long patientId;
    public static Patient patient;

    @Mock
    private IPatientService patientService;

    @BeforeEach
    public void setUp() {
        patientId = 1L;
        patient = new Patient("Luis", "Montero", LocalDate.now(), "Loco", "Masculino", "Box 1", 101);
        patient.setId(patientId);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPatient() {
        when(patientService.getPatient(patientId)).thenReturn(patient);

        Patient foundPatient = patientService.getPatient(patientId);

        assertNotNull(foundPatient);
        assertEquals(patientId, foundPatient.getId());
        assertEquals("Luis", foundPatient.getName());
    }

    @Test
    public void testGetAllPatients() {
        when(patientService.getAllPatients()).thenReturn(Collections.singletonList(patient));

        List<Patient> patients = patientService.getAllPatients();

        assertNotNull(patients);
        assertEquals(1, patients.size());
        assertEquals(patient, patients.get(0));
    }

    @Test
    public void testSavePatient() {
        when(patientService.savePatient(patient)).thenReturn(patient);

        Patient savedPatient = patientService.savePatient(patient);

        assertNotNull(savedPatient);
        assertEquals(patientId, savedPatient.getId());
        assertEquals("Luis", savedPatient.getName());
    }

    @Test
    public void testUpdatePatient() {
        when(patientService.updatePatient(patient)).thenReturn(patient);

        Patient updatedPatient = patientService.updatePatient(patient);

        assertNotNull(updatedPatient);
        assertEquals(patientId, updatedPatient.getId());
        assertEquals("Luis", updatedPatient.getName());
    }

    @Test
    public void testDeletePatient() {
        doNothing().when(patientService).deletePatient(patient);

        patientService.deletePatient(patient);

        verify(patientService, times(1)).deletePatient(patient);
    }

    @Test
    public void testDeletePatientById() {
        doNothing().when(patientService).deletePatientById(patientId);

        patientService.deletePatientById(patientId);

        verify(patientService, times(1)).deletePatientById(patientId);
    }
}
