package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.FullBloodCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullBloodCountRepository extends JpaRepository<FullBloodCount, Long> {
}
