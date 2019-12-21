//package com.edu.giadinh.studentregistration.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.edu.giadinh.studentregistration.dto.StudentRegistrationDto;
//import com.edu.giadinh.studentregistration.model.StudentRegistration;
//import com.edu.giadinh.studentregistration.service.EmailService;
//import com.edu.giadinh.studentregistration.service.StudentRegistrationService;
//
//@Controller
//public class SendMailController {
//
//	@Autowired
//	private StudentRegistrationService studentRegistrationService;
//
//	@ModelAttribute("student")
//	public StudentRegistrationDto stuDto() {
//		return new StudentRegistrationDto();
//	}
//
//	@RequestMapping(value="/xemHoSo", method = RequestMethod.GET)
//	public String xemHoSo() {
//		return "xemHoSo";
//	}
//	
//
//
//
////	@PostMapping
////	public String processXemHoSo(@Valid StudentRegistration form,BindingResult result, HttpServletRequest request) {
////		StudentRegistration stu = studentRegistrationService.findByEmail(form.getEmail());
////		if (stu == null) {
////			result.rejectValue("email", null, "We could not find an account for that e-mail address.");
////			return "xemHoSo";
////		}
////		Mail mail = new Mail();
////		mail.setFrom("user1@testmail.com");
////		mail.setTo(stu.getEmail());
////		mail.setSubject("Hello");
////
////		Map<String, Object> model = new HashMap<>();
////		model.put("stu", stu);
////		model.put("signature", "http://localhost:8070");
////		mail.setModel(model);
////		emailService.sendEmail(mail);
////		return "redirect:/xemHoSo?success";
////	}
//
//	@RequestMapping(value="/xemHoSo", method = RequestMethod.POST)
//	public String processXemHoSo(@ModelAttribute("student") @Valid StudentRegistrationDto stuDto, BindingResult result)
//			throws Exception {
//		StudentRegistration existingEmail = studentRegistrationService.findByEmail(stuDto.getEmail());
//		if (existingEmail == null) {
//			result.rejectValue("email", null, "Địa chỉ Email này không tồn tại!");
//		}
//		if (result.hasErrors()) {
//			return "xemHoSo";
//		}
//		return "redirect:/xemHoSoDangKyTuyenSinh";
//	}
//
//}
