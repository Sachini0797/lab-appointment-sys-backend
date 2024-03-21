package com.sachini.labappointmentsys.repository;

import com.sachini.labappointmentsys.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.labTechnician.id = :technicianId " +
            "AND a.appointmentDate = :date " +
            "AND ((a.startTime BETWEEN :startTime AND :endTime) OR " +
            "(a.endTime BETWEEN :startTime AND :endTime))")
    List<Appointment> findConflictingAppointments(@Param("technicianId") Long technicianId,
                                                  @Param("date") LocalDate date,
                                                  @Param("startTime") LocalTime startTime,
                                                  @Param("endTime") LocalTime endTime);
}

