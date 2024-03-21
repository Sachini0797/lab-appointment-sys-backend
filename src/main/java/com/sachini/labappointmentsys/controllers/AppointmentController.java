package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.Appointment;
import com.sachini.labappointmentsys.repository.AppointmentRepository;
import com.sachini.labappointmentsys.security.services.AppointmentService;
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

//    @PostMapping("/create")
//    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
//        Appointment createdAppointment = appointmentService.createAppointment(appointment);
//        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
//    }

    @PostMapping("/create")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        if (appointmentService.createOrUpdateAppointment(appointment)) {
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

//    @PutMapping("/updatea/{id}")
//    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
//        Appointment appointment = appointmentService.updateAppointment(id, updatedAppointment);
//        return ResponseEntity.ok(appointment);
//    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Object> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
//        boolean isAppointmentUpdated = appointmentService.createOrUpdateAppointment(appointment);
//        if (isAppointmentUpdated) {
//            return ResponseEntity.ok(Map.of("appointment", appointment, "message", "Appointment updated successfully"));
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Technician not available for the given time slot"));
//        }
//    }

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
