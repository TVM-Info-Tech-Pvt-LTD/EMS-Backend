package com.tvm.ems.service;

import com.tvm.ems.dto.ForgotDto;
import com.tvm.ems.model.ForgotPassword;

public interface ForgotPasswordService {
	void forgotPassword(String email);
	ForgotPassword getByEmail(String email);
	String changePassword(ForgotDto forgotDto);
}
