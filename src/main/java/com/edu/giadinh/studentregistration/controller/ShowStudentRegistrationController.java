package com.edu.giadinh.studentregistration.controller;

import java.security.Principal;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.giadinh.studentregistration.dto.StudentRegistrationDto;
import com.edu.giadinh.studentregistration.model.StudentRegistration;
import com.edu.giadinh.studentregistration.service.StudentRegistrationService;

@Controller
public class ShowStudentRegistrationController {

	@Autowired
	private StudentRegistrationService studentRegistrationService;

	@ModelAttribute("student")
	public StudentRegistrationDto stuDto() {
		return new StudentRegistrationDto();
	}

	@RequestMapping(value = "/xemHoSo", method = RequestMethod.GET)
	public String xemHoSo() {
		return "xemHoSo";
	}

	@RequestMapping(value = "/xemHoSoDangKyTuyenSinh", method = RequestMethod.GET)
	public String xemHoSoDangKyTuyenSinh() {

		return "xemHoSoDangKyTuyenSinh";
	}

//	@ModelAttribute("student")
//	public StudentRegistrationDto studentRegistrationDto(@PathVariable String email) {
//		StudentRegistration stu = studentRegistrationService.findByEmail(email);
//		return studentRegistrationService.studentRegistrationDto(stu);
//	}

	@RequestMapping(value = "/xemHoSo", method = RequestMethod.POST)
	public String processXemHoSo(@ModelAttribute("student") @Valid StudentRegistrationDto stuDto, BindingResult result, Principal principal,
			Model model) throws Exception {
		StudentRegistration existingEmail = studentRegistrationService.findByEmail(stuDto.getEmail());
		if (existingEmail == null) {
			result.rejectValue("email", null, "Địa chỉ Email này không tồn tại!");
		}
		if (result.hasErrors()) {
			return "xemHoSo";
		}
		model.addAttribute("student", existingEmail);
		return "xemHoSoDangKyTuyenSinh";
	}

	@RequestMapping(value = "/xemHoSoDangKyTuyenSinh", method = RequestMethod.POST)
	public String showUpdateInfoForm(@ModelAttribute("student") @Valid StudentRegistrationDto stuDto,BindingResult result ) {

		return "xemHoSoDangKyTuyenSinh";
	}

}
