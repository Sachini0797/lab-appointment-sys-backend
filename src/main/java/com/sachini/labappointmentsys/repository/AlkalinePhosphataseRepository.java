package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.AlkalinePhosphatase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlkalinePhosphataseRepository extends JpaRepository<AlkalinePhosphatase, Long> {
}
