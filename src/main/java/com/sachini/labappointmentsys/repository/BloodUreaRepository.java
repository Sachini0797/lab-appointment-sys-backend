package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.BloodUrea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodUreaRepository extends JpaRepository<BloodUrea, Long> {

}
