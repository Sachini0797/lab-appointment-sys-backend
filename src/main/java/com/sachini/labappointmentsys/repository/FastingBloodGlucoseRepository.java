package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.FastingBloodGlucose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FastingBloodGlucoseRepository extends JpaRepository<FastingBloodGlucose, Long> {
}
