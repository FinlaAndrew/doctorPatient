package com.ust.appointment.entity;

import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;
	private long userId;
	private LocalDate appointmentDate;
	private LocalTime appointTime;
	private long doctorId;
	private String doctorName;
	private String department;
	private String userName;
	private String details;

}
