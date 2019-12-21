package com.edu.giadinh.studentregistration.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students_registration")
public class StudentRegistration {
	
	// Thông tin hộ chung
	private String studentCode;

	private String fullName;

	private String placeOfBirth;

	private String idOfStudent;

	private String phoneNumber;

	private String dateOfBirth;

	@Indexed
	private String email;

	private String gender;

	private String areaCode;

	private String majorRegistration;

	// Thông tin hộ khẩu
	private String address;

	private String subDistrict;

	private String district;

	private String province;

	// Thông tin phụ huynh
	private String nameOfFather;

	private String phoneNumberOfFather;

	private String nameOfMother;

	private String phoneNumberOfMother;

	// Điểm học bạ
	private String mathScoresInSchoolReport;

	private String chemistryScoresInSchoolReport;

	private String physicsScoresInSchoolReport;

	private String literaryScoresInSchoolReport;

	// Điểm thi tốt nghiệp
	private String mathScoresOfGraduationTest;

	private String chemistryScoresOfGraduationTest;

	private String physicsScoresOfGraduationTest;

	private String literaryScoresOfGraduationTest;

	// Thông tin trường cấp 3
	private String addressSchool;

	private String districtSchool;

	private String subDistrictSchool;

	private String provinceSchool;

	// Thông tin thêm
	private String addressNow;

	private String notes;

	private String status;

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getIdOfStudent() {
		return idOfStudent;
	}

	public void setIdOfStudent(String idOfStudent) {
		this.idOfStudent = idOfStudent;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getMajorRegistration() {
		return majorRegistration;
	}

	public void setMajorRegistration(String majorRegistration) {
		this.majorRegistration = majorRegistration;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNameOfFather() {
		return nameOfFather;
	}

	public void setNameOfFather(String nameOfFather) {
		this.nameOfFather = nameOfFather;
	}

	public String getPhoneNumberOfFather() {
		return phoneNumberOfFather;
	}

	public void setPhoneNumberOfFather(String phoneNumberOfFather) {
		this.phoneNumberOfFather = phoneNumberOfFather;
	}

	public String getNameOfMother() {
		return nameOfMother;
	}

	public void setNameOfMother(String nameOfMother) {
		this.nameOfMother = nameOfMother;
	}

	public String getPhoneNumberOfMother() {
		return phoneNumberOfMother;
	}

	public void setPhoneNumberOfMother(String phoneNumberOfMother) {
		this.phoneNumberOfMother = phoneNumberOfMother;
	}

	public String getMathScoresInSchoolReport() {
		return mathScoresInSchoolReport;
	}

	public void setMathScoresInSchoolReport(String mathScoresInSchoolReport) {
		this.mathScoresInSchoolReport = mathScoresInSchoolReport;
	}

	public String getChemistryScoresInSchoolReport() {
		return chemistryScoresInSchoolReport;
	}

	public void setChemistryScoresInSchoolReport(String chemistryScoresInSchoolReport) {
		this.chemistryScoresInSchoolReport = chemistryScoresInSchoolReport;
	}

	public String getPhysicsScoresInSchoolReport() {
		return physicsScoresInSchoolReport;
	}

	public void setPhysicsScoresInSchoolReport(String physicsScoresInSchoolReport) {
		this.physicsScoresInSchoolReport = physicsScoresInSchoolReport;
	}

	public String getLiteraryScoresInSchoolReport() {
		return literaryScoresInSchoolReport;
	}

	public void setLiteraryScoresInSchoolReport(String literaryScoresInSchoolReport) {
		this.literaryScoresInSchoolReport = literaryScoresInSchoolReport;
	}

	public String getMathScoresOfGraduationTest() {
		return mathScoresOfGraduationTest;
	}

	public void setMathScoresOfGraduationTest(String mathScoresOfGraduationTest) {
		this.mathScoresOfGraduationTest = mathScoresOfGraduationTest;
	}

	public String getChemistryScoresOfGraduationTest() {
		return chemistryScoresOfGraduationTest;
	}

	public void setChemistryScoresOfGraduationTest(String chemistryScoresOfGraduationTest) {
		this.chemistryScoresOfGraduationTest = chemistryScoresOfGraduationTest;
	}

	public String getPhysicsScoresOfGraduationTest() {
		return physicsScoresOfGraduationTest;
	}

	public void setPhysicsScoresOfGraduationTest(String physicsScoresOfGraduationTest) {
		this.physicsScoresOfGraduationTest = physicsScoresOfGraduationTest;
	}

	public String getLiteraryScoresOfGraduationTest() {
		return literaryScoresOfGraduationTest;
	}

	public void setLiteraryScoresOfGraduationTest(String literaryScoresOfGraduationTest) {
		this.literaryScoresOfGraduationTest = literaryScoresOfGraduationTest;
	}

	public String getAddressSchool() {
		return addressSchool;
	}

	public void setAddressSchool(String addressSchool) {
		this.addressSchool = addressSchool;
	}

	public String getDistrictSchool() {
		return districtSchool;
	}

	public void setDistrictSchool(String districtSchool) {
		this.districtSchool = districtSchool;
	}

	public String getSubDistrictSchool() {
		return subDistrictSchool;
	}

	public void setSubDistrictSchool(String subDistrictSchool) {
		this.subDistrictSchool = subDistrictSchool;
	}

	public String getProvinceSchool() {
		return provinceSchool;
	}

	public void setProvinceSchool(String provinceSchool) {
		this.provinceSchool = provinceSchool;
	}

	public String getAddressNow() {
		return addressNow;
	}

	public void setAddressNow(String addressNow) {
		this.addressNow = addressNow;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
