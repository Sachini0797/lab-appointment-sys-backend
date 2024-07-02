package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.AlkalinePhosphatase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlkalinePhosphataseRepository extends JpaRepository<AlkalinePhosphatase, Long> {

    AlkalinePhosphatase findByAppointmentId(Long appointmentId);
    List<AlkalinePhosphatase> findAllByUid(Long uid);



}
