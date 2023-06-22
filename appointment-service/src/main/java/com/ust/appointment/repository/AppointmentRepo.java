package com.ust.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.appointment.entity.Appointment;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentByUserId(long id);
    Optional<List<Appointment>> findAppointmentByUserIdAndDoctorId(Long userId, Long doctorId);

}
