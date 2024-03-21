package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.LiverFunctionTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiverFunctionTestRepository extends JpaRepository<LiverFunctionTest, Long> {
}
