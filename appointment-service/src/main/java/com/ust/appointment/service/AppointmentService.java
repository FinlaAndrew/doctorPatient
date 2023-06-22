package com.ust.appointment.service;

import java.util.List;
import java.util.Optional;

import com.ust.appointment.entity.Appointment;
import com.ust.appointment.exception.AppointmentAlreadyExistException;
import com.ust.appointment.exception.AppointmentNotFoundException;

public interface AppointmentService {


	Appointment createAppointment(Appointment appointment) throws AppointmentAlreadyExistException;

	List<Appointment> viewAllAppointmentsByUser(Long userId) throws AppointmentNotFoundException;

	void deleteAppointment(Long appointmentId)throws AppointmentNotFoundException;

	Optional<Appointment> findByAppId(Long appointmentId) throws AppointmentNotFoundException;
	Optional<List<Appointment>> findByDocIdAndUserId(Long DoctorId,Long userId) throws AppointmentNotFoundException;

}
