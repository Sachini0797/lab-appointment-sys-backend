package com.sachini.labappointmentsys.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 50)
    private String name;

    private LocalDate appointmentDate;

    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne // Many appointments can have one user
    @JoinColumn(name = "user_id") // Specifies the foreign key column in the database
    private User user; // The user who scheduled the appointment

    @ManyToOne // Many appointments can have one doctor
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne // Many appointments can have one lab technician
    @JoinColumn(name = "lab_technician_id")
    private LabTechnician labTechnician;

    @ManyToMany
    @JoinTable(
            name = "appointment_lab_test",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "lab_test_id")
    )
    private Set<LabTest> labTests = new HashSet<>();




    public Appointment () {}

    public Appointment(String name, LocalDate appointmentDate, LocalTime startTime, LocalTime endTime, User user, Doctor doctor, LabTechnician labTechnician, Set<LabTest> labTests) {
        this.name = name;
        this.appointmentDate = appointmentDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.user = user;
        this.doctor = doctor;
        this.labTechnician = labTechnician;
        this.labTests = labTests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LabTechnician getLabTechnician() {
        return labTechnician;
    }

    public void setLabTechnician(LabTechnician labTechnician) {
        this.labTechnician = labTechnician;
    }

    public Set<LabTest> getLabTests() {
        return labTests;
    }

    public void setLabTests(Set<LabTest> labTests) {
        this.labTests = labTests;
    }
}
