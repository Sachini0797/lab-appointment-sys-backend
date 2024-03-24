package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.Appointment;
import com.sachini.labappointmentsys.models.LabTestInvoice;
import com.sachini.labappointmentsys.repository.AppointmentRepository;
import com.sachini.labappointmentsys.security.services.AppointmentService;
import com.sachini.labappointmentsys.security.services.LabTestInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin/labTestInvoice")
public class LabTestInvoiceController {

    @Autowired
    private LabTestInvoiceService labTestInvoiceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/all")
    public List<LabTestInvoice> getAllLabTestInvoices() {
        return labTestInvoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity <LabTestInvoice> getLabTestInvoiceById(@PathVariable("id") Long id) {
        Optional <LabTestInvoice> labTestInvoiceOptional = labTestInvoiceService.getInvoiceById((id));
        return labTestInvoiceOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
//    public  LabTestInvoice createLabTestInvoice(@RequestBody LabTestInvoice labTestInvoice) {
//        return labTestInvoiceService.createInvoice(labTestInvoice);
//
//    }

    public ResponseEntity<?> createLabTestInvoice(@RequestBody LabTestInvoice labTestInvoice) {
        // Retrieve the appointment by its ID from the LabTestInvoice
        Long appointmentId = labTestInvoice.getAppointment().getId();
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        if (!appointmentOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found with ID: " + appointmentId);
        }
        // Set the generatedAt timestamp
        LocalDateTime generatedAt = LocalDateTime.now();
        labTestInvoice.setGeneratedAt(generatedAt);

        // Save the LabTestInvoice
        LabTestInvoice savedInvoice = labTestInvoiceService.createInvoice(labTestInvoice);

        if (savedInvoice != null) {
            return ResponseEntity.ok(savedInvoice);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create LabTestInvoice.");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<LabTestInvoice> updateLabTestInvoice(@PathVariable("id")Long id, @RequestBody LabTestInvoice labTestInvoice) {
        LabTestInvoice updateInvoice = labTestInvoiceService.updateInvoice(id, labTestInvoice);
        return updateInvoice != null ? ResponseEntity.ok(updateInvoice) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabTestInvoice (@PathVariable("id") Long id) {
        boolean deleted = labTestInvoiceService.deleteInvoiceById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.noContent().build();
    }

}
