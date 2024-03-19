package com.sachini.labappointmentsys.controllers;

import com.sachini.labappointmentsys.models.LabTestInvoice;
import com.sachini.labappointmentsys.security.services.LabTestInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/labTestInvoice")
public class LabTestInvoiceController {

    @Autowired
    private LabTestInvoiceService labTestInvoiceService;

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
    public LabTestInvoice createLabTestInvoice(@RequestBody LabTestInvoice labTestInvoice) {
        return labTestInvoiceService.createInvoice(labTestInvoice);
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
