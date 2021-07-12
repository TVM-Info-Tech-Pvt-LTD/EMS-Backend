package com.tvm.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvm.ems.model.ForgotPassword;

@Repository

public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, Long> {
	ForgotPassword findByEmployeeEmail(String email);
}
