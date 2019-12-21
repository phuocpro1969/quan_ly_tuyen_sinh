package com.edu.giadinh.studentregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.edu.giadinh.studentregistration.dto.StudentRegistrationDto;
import com.edu.giadinh.studentregistration.model.StudentRegistration;
import com.edu.giadinh.studentregistration.repository.StudentRegistrationRepository;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

	@Autowired
	private StudentRegistrationRepository studentRegistrationRepository;
	
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public StudentRegistration save(StudentRegistration student) {
		StudentRegistration stu = new StudentRegistration();

		// Thông tin hộ khẩu
		stu.setStudentCode(student.getStudentCode());
		stu.setFullName(student.getFullName());
		stu.setPlaceOfBirth(student.getPlaceOfBirth());
		stu.setIdOfStudent(student.getIdOfStudent());
		stu.setPhoneNumber(student.getPhoneNumber());
		stu.setDateOfBirth(student.getDateOfBirth());
		stu.setEmail(student.getEmail());
		if(student.getGender().equals("Nam"))
		{
			stu.setGender("Nam");
		}else {
			stu.setGender("Nữ");
		}
		stu.setAreaCode(student.getAreaCode());
		stu.setMajorRegistration(student.getMajorRegistration());
		// Thông tin hộ khẩu
		stu.setAddress(student.getAddress());
		stu.setSubDistrict(student.getSubDistrict());
		stu.setDistrict(student.getDistrict());
		stu.setProvince(student.getProvince());
		// Thông tin phụ huynh
		stu.setNameOfFather(student.getNameOfFather());
		stu.setPhoneNumberOfFather(student.getPhoneNumberOfFather());
		stu.setNameOfMother(student.getNameOfMother());
		stu.setPhoneNumberOfMother(student.getPhoneNumberOfMother());
		// Điểm học bạ
		stu.setMathScoresInSchoolReport(student.getMathScoresInSchoolReport());
		stu.setChemistryScoresInSchoolReport(student.getChemistryScoresInSchoolReport());
		stu.setPhysicsScoresInSchoolReport(student.getPhysicsScoresInSchoolReport());
		stu.setLiteraryScoresInSchoolReport(student.getLiteraryScoresInSchoolReport());
		// Điểm thi tốt nghiệp
		stu.setMathScoresOfGraduationTest(student.getMathScoresOfGraduationTest());
		stu.setChemistryScoresOfGraduationTest(student.getChemistryScoresOfGraduationTest());
		stu.setPhysicsScoresOfGraduationTest(student.getPhysicsScoresOfGraduationTest());
		stu.setLiteraryScoresOfGraduationTest(student.getLiteraryScoresOfGraduationTest());
		// Thông tin trường cấp 3
		stu.setAddressSchool(student.getAddressSchool());
		stu.setDistrictSchool(student.getDistrictSchool());
		stu.setSubDistrictSchool(student.getSubDistrictSchool());
		stu.setProvinceSchool(student.getProvinceSchool());
		// Thông tin thêm
		stu.setAddressNow(student.getAddressNow());
		stu.setNotes(student.getNotes());
		stu.setStatus("Chờ duyệt");
		return studentRegistrationRepository.save(stu);
	}

	@Override
	public List<StudentRegistration> findAll() {
		return studentRegistrationRepository.findAll();
	}


	@Override
	public List<StudentRegistration> findStudentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentRegistration findByEmail(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
        StudentRegistration SR = mongoTemplate.findOne(query, StudentRegistration.class);
        if (SR == null)
        	return null;
		return SR;
        //return studentRegistrationRepository.findUserByEmail(email);
	}

	@Override
	public StudentRegistrationDto studentRegistrationDto(StudentRegistration stu) {
		StudentRegistrationDto stuDto = new StudentRegistrationDto();
		stuDto.setStudentCode(stu.getStudentCode());
		stuDto.setFullName(stu.getFullName());
		stuDto.setPlaceOfBirth(stu.getPlaceOfBirth());
		stuDto.setIdOfStudent(stu.getIdOfStudent());
		stuDto.setPhoneNumber(stu.getPhoneNumber());
		stuDto.setDateOfBirth(stu.getDateOfBirth());
		stuDto.setEmail(stu.getEmail());
		if (stu.getGender().equals("Nam")) {
			stuDto.setGender("Nam");
		} else {
			stuDto.setGender("Nữ");
		}
		stuDto.setAreaCode(stu.getAreaCode());
		stuDto.setMajorRegistration(stu.getMajorRegistration());
		// Thông tin hộ khẩu
		stuDto.setAddress(stu.getAddress());
		stuDto.setSubDistrict(stu.getSubDistrict());
		stuDto.setDistrict(stu.getDistrict());
		stuDto.setProvince(stu.getProvince());
		// Thông tin phụ huynh
		stuDto.setNameOfFather(stu.getNameOfFather());
		stuDto.setPhoneNumberOfFather(stu.getPhoneNumberOfFather());
		stuDto.setNameOfMother(stu.getNameOfMother());
		stuDto.setPhoneNumberOfMother(stu.getPhoneNumberOfMother());
		// Điểm học bạ
		stuDto.setMathScoresInSchoolReport(stu.getMathScoresInSchoolReport());
		stuDto.setChemistryScoresInSchoolReport(stu.getChemistryScoresInSchoolReport());
		stuDto.setPhysicsScoresInSchoolReport(stu.getPhysicsScoresInSchoolReport());
		stuDto.setLiteraryScoresInSchoolReport(stu.getLiteraryScoresInSchoolReport());
		// Điểm thi tốt nghiệp
		stuDto.setMathScoresOfGraduationTest(stu.getMathScoresOfGraduationTest());
		stuDto.setChemistryScoresOfGraduationTest(stu.getChemistryScoresOfGraduationTest());
		stuDto.setPhysicsScoresOfGraduationTest(stu.getPhysicsScoresOfGraduationTest());
		stuDto.setLiteraryScoresOfGraduationTest(stu.getLiteraryScoresOfGraduationTest());
		// Thông tin trường cấp 3
		stuDto.setAddressSchool(stu.getAddressSchool());
		stuDto.setDistrictSchool(stu.getDistrictSchool());
		stuDto.setSubDistrictSchool(stu.getSubDistrictSchool());
		stuDto.setProvinceSchool(stu.getProvinceSchool());
		// Thông tin thêm
		stuDto.setAddressNow(stu.getAddressNow());
		stuDto.setNotes(stu.getNotes());
		stuDto.setStatus("Chờ duyệt");
		return stuDto;
	}

	@Override
	public StudentRegistration save(StudentRegistrationDto stuDto) {
		StudentRegistration stu = new StudentRegistration();
		stu.setStudentCode(stuDto.getStudentCode());
		stu.setFullName(stuDto.getFullName());
		stu.setPlaceOfBirth(stuDto.getPlaceOfBirth());
		stu.setIdOfStudent(stuDto.getIdOfStudent());
		stu.setPhoneNumber(stuDto.getPhoneNumber());
		stu.setDateOfBirth(stuDto.getDateOfBirth());
		stu.setEmail(stuDto.getEmail());
		if (stuDto.getGender().equals("Nam")) {
			stu.setGender("Nam");
		} else {
			stu.setGender("Nữ");
		}
		stu.setAreaCode(stuDto.getAreaCode());
		stu.setMajorRegistration(stuDto.getMajorRegistration());
		// Thông tin hộ khẩu
		stu.setAddress(stuDto.getAddress());
		stu.setSubDistrict(stuDto.getSubDistrict());
		stu.setDistrict(stuDto.getDistrict());
		stu.setProvince(stuDto.getProvince());
		// Thông tin phụ huynh
		stu.setNameOfFather(stuDto.getNameOfFather());
		stu.setPhoneNumberOfFather(stuDto.getPhoneNumberOfFather());
		stu.setNameOfMother(stuDto.getNameOfMother());
		stu.setPhoneNumberOfMother(stuDto.getPhoneNumberOfMother());
		// Điểm học bạ
		stu.setMathScoresInSchoolReport(stuDto.getMathScoresInSchoolReport());
		stu.setChemistryScoresInSchoolReport(stuDto.getChemistryScoresInSchoolReport());
		stu.setPhysicsScoresInSchoolReport(stuDto.getPhysicsScoresInSchoolReport());
		stu.setLiteraryScoresInSchoolReport(stuDto.getLiteraryScoresInSchoolReport());
		// Điểm thi tốt nghiệp
		stu.setMathScoresOfGraduationTest(stuDto.getMathScoresOfGraduationTest());
		stu.setChemistryScoresOfGraduationTest(stuDto.getChemistryScoresOfGraduationTest());
		stu.setPhysicsScoresOfGraduationTest(stuDto.getPhysicsScoresOfGraduationTest());
		stu.setLiteraryScoresOfGraduationTest(stuDto.getLiteraryScoresOfGraduationTest());
		// Thông tin trường cấp 3
		stu.setAddressSchool(stuDto.getAddressSchool());
		stu.setDistrictSchool(stuDto.getDistrictSchool());
		stu.setSubDistrictSchool(stuDto.getSubDistrictSchool());
		stu.setProvinceSchool(stuDto.getProvinceSchool());
		// Thông tin thêm
		stu.setAddressNow(stuDto.getAddressNow());
		stu.setNotes(stuDto.getNotes());
		stu.setStatus("Chờ duyệt");
		return studentRegistrationRepository.save(stu);
	}

}
