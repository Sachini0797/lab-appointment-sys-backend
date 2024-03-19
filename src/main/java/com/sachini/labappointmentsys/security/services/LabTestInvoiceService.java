package com.sachini.labappointmentsys.security.services;

import com.sachini.labappointmentsys.models.Doctor;
import com.sachini.labappointmentsys.models.LabTestInvoice;
import com.sachini.labappointmentsys.repository.LabTestInvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LabTestInvoiceService {

    private final LabTestInvoiceRepository labTestInvoiceRepository;

    @Autowired
    public LabTestInvoiceService(LabTestInvoiceRepository labTestInvoiceRepository) {
        this.labTestInvoiceRepository = labTestInvoiceRepository;
    }

    public LabTestInvoice createInvoice(LabTestInvoice invoice) {
        // Implement logic to create an invoice
        return labTestInvoiceRepository.save(invoice);
    }

    public Optional<LabTestInvoice> getInvoiceById(Long id) {
        // Implement logic to retrieve an invoice by its ID
        return labTestInvoiceRepository.findById(id);
    }

    public List<LabTestInvoice> getAllInvoices() {
        // Implement logic to retrieve all invoices
        return labTestInvoiceRepository.findAll();
    }

//    public void updateInvoice(LabTestInvoice invoice) {
//         labTestInvoiceRepository.save(invoice);
//    }

    public LabTestInvoice updateInvoice(Long id, LabTestInvoice labTestInvoice) {
        if (labTestInvoiceRepository.existsById(id)) {
            labTestInvoice.setId(id);
            return labTestInvoiceRepository.save(labTestInvoice);
        }
        return null; // Or throw an exception
    }

//    public void deleteInvoiceById(Long id) {
//         labTestInvoiceRepository.deleteById(id);
//    }

    public boolean deleteInvoiceById(Long id) {
        if (labTestInvoiceRepository.existsById(id)) {
            labTestInvoiceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
