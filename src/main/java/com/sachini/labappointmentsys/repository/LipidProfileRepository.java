package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.LipidProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LipidProfileRepository extends JpaRepository<LipidProfile, Long> {
}
