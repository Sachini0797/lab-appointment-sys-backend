package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest, Long> {
}
