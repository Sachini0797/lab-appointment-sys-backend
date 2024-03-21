package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.DengueNsiRapidipTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DengueNsiRapidipTestRepository extends JpaRepository<DengueNsiRapidipTest, Long> {
}
