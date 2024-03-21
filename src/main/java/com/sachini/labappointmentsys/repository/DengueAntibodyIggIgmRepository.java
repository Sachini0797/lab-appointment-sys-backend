package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.DengueAntibodyIggIgm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DengueAntibodyIggIgmRepository extends JpaRepository<DengueAntibodyIggIgm, Long> {
}
