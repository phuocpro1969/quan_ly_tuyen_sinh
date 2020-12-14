package com.edu.giadinh.studentregistration.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.giadinh.studentregistration.dto.StudentRegistrationDto;
import com.edu.giadinh.studentregistration.model.Mail;
import com.edu.giadinh.studentregistration.model.StudentRegistration;
import com.edu.giadinh.studentregistration.service.EmailService;
import com.edu.giadinh.studentregistration.service.StudentRegistrationService;

@Controller
public class StudentRegistrationController {

	@Autowired
	private StudentRegistrationService studentRegistrationService;

	@Autowired
	private EmailService emailService;

	@ModelAttribute("student")
	public StudentRegistrationDto stuDto() {
		return new StudentRegistrationDto();
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = "/dangkytuyensinh", method = RequestMethod.GET)
	public ModelAndView dangKyTuyenSinh() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dangkytuyensinh");
		return modelAndView;
	}

	@RequestMapping(value = "/dangkytuyensinh", method = RequestMethod.POST)
	public ModelAndView dangKyTuyenSinh(@ModelAttribute("student") @Valid StudentRegistrationDto stuDto,
			BindingResult result) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		StudentRegistration existingEmail = studentRegistrationService.findByEmail(stuDto.getEmail());
		if (existingEmail != null) {
			result.rejectValue("email", null, "Địa chỉ Email này đã có người đăng ký!");
		}
		if (result.hasErrors()) {
			modelAndView.setViewName("dangkytuyensinh");
			return modelAndView;
		}
		studentRegistrationService.save(stuDto);

		Mail mail = new Mail();
		mail.setFrom("user1@testmail.com");
		mail.setTo(stuDto.getEmail());
		mail.setSubject("UIT");

		Map<String, Object> model = new HashMap<>();
		model.put("stu", stuDto);
		model.put("signature", "http://localhost:8070");
		mail.setModel(model);
		emailService.sendEmail(mail);
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
