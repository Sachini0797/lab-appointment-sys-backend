package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.Appointment;
import com.sachini.labappointmentsys.repository.AppointmentRepository;
import com.sachini.labappointmentsys.security.services.AppointmentService;
import com.sachini.labappointmentsys.security.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/create")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        if (appointmentService.createOrUpdateAppointment(appointment)) {
            emailService.sendAppointmentEmail(appointment.getUser().getEmail(), appointment.getUser().getId(),appointment.getId() , appointment.getUser().getUsername(), appointment.getAppointmentDate(), appointment.getStartTime(), appointment.getEndTime());


            return ResponseEntity.ok( appointment);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Technician not available for the given time slot");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(appointment);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable("id") Long id, @RequestBody Appointment appointmentDetails) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);

        if (appointmentOptional.isPresent()) {
            Appointment existingAppointment = appointmentOptional.get();

            // Update the existing appointment details
            existingAppointment.setDoctor(appointmentDetails.getDoctor());
            existingAppointment.setLabTechnician(appointmentDetails.getLabTechnician());
            existingAppointment.setLabTests(appointmentDetails.getLabTests());
            existingAppointment.setStartTime(appointmentDetails.getStartTime());
            existingAppointment.setEndTime(appointmentDetails.getEndTime());
            existingAppointment.setAppointmentDate(appointmentDetails.getAppointmentDate());

            // Check if the updated appointment conflicts with existing appointments
            if (appointmentService.createOrUpdateAppointment(existingAppointment)) {
                return ResponseEntity.ok("Appointment updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Technician not available for the given time slot");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
