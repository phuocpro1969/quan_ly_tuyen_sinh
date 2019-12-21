package com.edu.giadinh.studentregistration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.giadinh.studentregistration.dto.StudentRegistrationDto;
import com.edu.giadinh.studentregistration.model.StudentRegistration;

@Service
public interface StudentRegistrationService {
	StudentRegistration save(StudentRegistration student);

	List<StudentRegistration> findAll();
	
	StudentRegistration findByEmail(String email);

	StudentRegistrationDto studentRegistrationDto(StudentRegistration stu);
	
	StudentRegistration save(StudentRegistrationDto stuDto);

	List<StudentRegistration> findStudentById(Long id);
}
