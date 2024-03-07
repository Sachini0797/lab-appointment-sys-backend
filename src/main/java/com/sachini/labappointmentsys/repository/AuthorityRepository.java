package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.enums.UserTypes;
import com.sachini.labappointmentsys.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Optional<Authority> findByName(UserTypes name);

}
