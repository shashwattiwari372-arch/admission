package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.CandidatePayment;
import com.example.employeecrud.tables.repository.CandidatePaymentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `candidate_payment` at /api/candidate-payment. */
@RestController
@RequestMapping("/api/candidate-payment")
public class CandidatePaymentController extends BaseCrudController<CandidatePayment, Integer> {

    public CandidatePaymentController(CandidatePaymentRepository repository) {
        super(repository);
    }
}
