package org.example.clinicapostpandemiademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente", nullable = false, unique = true)
    private long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "apellido", nullable = false, length = 50)
    private String surname;

    @Column(name = "diagnostico", nullable = false, length = 250)
    private String diagnostic;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate birthDate;

    @Column(name = "sexo", nullable = false, length = 20)
    private String sex;

    @Column(name = "box", nullable = false, length = 20)
    private String box;

    @Column(name = "numero_cama", nullable = false)
    private int bedNumber;

    public Patient(String name, String surname, LocalDate birthDate, String diagnostic, String sex, String box, int bedNumber) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.diagnostic = diagnostic;
        this.sex = sex;
        this.box = box;
        this.bedNumber = bedNumber;
    }
}