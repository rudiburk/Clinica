package org.example.clinicapostpandemiademo.controller;

import org.example.clinicapostpandemiademo.entity.Patient;
import org.example.clinicapostpandemiademo.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "listpatients";
    }

    @GetMapping("/new")
    public String showNewPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientform";
    }

    @PostMapping("/save")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/edit/{id}")
    public String showEditPatientForm(@PathVariable("id") long id, Model model) {
        Patient patient = patientService.getPatient(id);
        model.addAttribute("patient", patient);
        return "patientform";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") long id) {
        patientService.deletePatientById(id);
        return "redirect:/patients";
    }
}