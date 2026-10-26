package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.CandidateOtp;
import com.example.employeecrud.tables.repository.CandidateOtpRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `candidate_otp` at /api/candidate-otp. */
@RestController
@RequestMapping("/api/candidate-otp")
public class CandidateOtpController extends BaseCrudController<CandidateOtp, Integer> {

    public CandidateOtpController(CandidateOtpRepository repository) {
        super(repository);
    }
}
