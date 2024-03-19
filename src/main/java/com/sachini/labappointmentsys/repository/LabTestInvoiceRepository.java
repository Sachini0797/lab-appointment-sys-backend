package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.LabTestInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestInvoiceRepository extends JpaRepository<LabTestInvoice, Long> {
}
