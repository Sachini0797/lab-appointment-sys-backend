package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.LabTechnician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTechnicianRepository extends JpaRepository<LabTechnician, Long> {

}
