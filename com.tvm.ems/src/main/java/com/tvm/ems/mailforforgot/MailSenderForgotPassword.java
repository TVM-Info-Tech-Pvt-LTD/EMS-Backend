package com.tvm.ems.mailforforgot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tvm.ems.model.Employee;
import com.tvm.ems.model.ForgotPassword;
import com.tvm.ems.service.EmployeeService;
import com.tvm.ems.service.ForgotPasswordService;

@Service
public class MailSenderForgotPassword {
	@Autowired
    private JavaMailSender javaMailSender;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ForgotPasswordService forgotPasswordService;

	public void sendEmail(String email) {
		Employee employee=employeeService.getByEmail(email);
        ForgotPassword forgotPassword=forgotPasswordService.getByEmail(email);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Reset Password");
        msg.setText("Hello "+employee.getEmployeeName()+" \n OTP ; "+forgotPassword.getOtp());

        javaMailSender.send(msg);

    }
	
		

}
