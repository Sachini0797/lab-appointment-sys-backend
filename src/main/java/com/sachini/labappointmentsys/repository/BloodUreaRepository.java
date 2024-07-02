package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.AlkalinePhosphatase;
import com.sachini.labappointmentsys.models.BloodUrea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodUreaRepository extends JpaRepository<BloodUrea, Long> {

    BloodUrea findByAppointmentId(Long appointmentId);

    List<BloodUrea> findAllByUid(Long uid);



}
