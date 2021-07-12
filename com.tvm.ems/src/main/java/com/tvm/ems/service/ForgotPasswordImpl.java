package com.tvm.ems.service;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.ems.dto.ForgotDto;
import com.tvm.ems.mailforforgot.MailSenderForgotPassword;
import com.tvm.ems.model.Employee;
import com.tvm.ems.model.ForgotPassword;
import com.tvm.ems.repository.ForgotPasswordRepository;
@Service
public class ForgotPasswordImpl implements ForgotPasswordService{
	@Autowired
	private ForgotPasswordRepository forgotPasswordRepository;
	@Autowired
	private MailSenderForgotPassword mailSender;
	@Autowired
	private EmployeeService employeeService;
	Supplier<String> s=()->{
		String s="";
		Random rand =new Random();
		for(int i=0;i<4;) {
			s+=rand.nextInt(10);
			i++;
		}
		return s;
	};
	@Override
	public void forgotPassword(String email) {
		ForgotPassword forgotpassword=new ForgotPassword();
		forgotpassword.setEmployeeEmail(email);
		forgotpassword.setOtp(s.get());
		forgotPasswordRepository.save(forgotpassword);
		mailSender.sendEmail(email);
		
	}
	@Override
	public ForgotPassword getByEmail(String email) {
		ForgotPassword forgotPassword=forgotPasswordRepository.findByEmployeeEmail(email);
		return forgotPassword;
	}
	@Override
	public String changePassword(ForgotDto forgotDto) {
		String email=forgotDto.getEmail();
		ForgotPassword forgotPassword=getByEmail(email);
		Employee employee=employeeService.getByEmail(email);
		if(forgotDto.getOtp().equals(forgotPassword.getOtp())) {
		employee.setEmployeePassword(forgotDto.getNewPassword());
		
		employeeService.saveEmployee(employee);
		forgotPasswordRepository.deleteById(forgotPassword.getId());
		}
		return null;
	}

}
