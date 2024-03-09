package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.enums.ERoles;
import com.sachini.labappointmentsys.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

     Optional<Role> findByName(ERoles name);
}
