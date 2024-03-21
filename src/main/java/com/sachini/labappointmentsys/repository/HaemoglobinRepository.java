package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.Haemoglobin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaemoglobinRepository extends JpaRepository<Haemoglobin, Long> {
}
