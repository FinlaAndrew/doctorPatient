package com.ust.admin.service;

import com.ust.admin.domain.Doctor;
import com.ust.admin.exception.DoctorAlreadyExistException;
import com.ust.admin.exception.DoctorNotFoundException;
import com.ust.admin.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public Doctor createDoctor(Doctor doctor) throws DoctorAlreadyExistException {
        if(doctorRepository.existsById(doctor.getDoctorId())){
            throw new DoctorAlreadyExistException("Already Exist");
        }

        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) throws DoctorNotFoundException {

        Optional<Doctor> doc =doctorRepository.findById(doctor.getDoctorId());
        if(doc.isEmpty()){
            throw new DoctorNotFoundException(" Doctor not Found");
        }
        var response=doc.get();
        response.setDoctorId(doctor.getDoctorId());
        response.setDoctorName(doctor.getDoctorName());
        response.setDepartment(doctor.getDepartment());
        return doctorRepository.save(response);
    }


    @Override
    public void deleteDoctor(Doctor doctor) throws DoctorNotFoundException {
        Optional<Doctor> doc =doctorRepository.findById(doctor.getDoctorId());
        if(doc.isEmpty()){
            throw new DoctorNotFoundException(" Doctor not Found");
        }
        doctorRepository.delete(doctor);
    }

    @Override
    public Optional<Doctor> findDoctor(String doctorName) throws DoctorNotFoundException {
        Optional<Doctor> doc =doctorRepository.findByDoctorName(doctorName);
        if(doc.isEmpty()){
            throw new DoctorNotFoundException(" Doctor not Found");
        }
        return doc;
    }

    @Override
    public Optional<Doctor> findById(Long doctorId) throws DoctorNotFoundException {
        Optional<Doctor> doc =doctorRepository.findById(doctorId);
        if(doc.isEmpty()){
            throw new DoctorNotFoundException(" Doctor not Found");
        }
       return doc;

    }

    @Override
    public List<Doctor> findByDept(String department) throws DoctorNotFoundException {
        List<Doctor> doc =doctorRepository.findByDepartment(department);
        if(doc.size()==0){
            throw new DoctorNotFoundException(" Doctor not Found");
        }
        return doc;
    }

    @Override
    public List<Doctor> findAll() throws DoctorNotFoundException {
        List<Doctor> doc =doctorRepository.findAll();
        if(doc.size()==0){
            throw new DoctorNotFoundException(" Doctors not Found");
        }
        return doctorRepository.findAll();
    }
}
