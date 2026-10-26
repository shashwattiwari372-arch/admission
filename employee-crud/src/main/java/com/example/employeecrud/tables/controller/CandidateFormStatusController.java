package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.CandidateFormStatus;
import com.example.employeecrud.tables.repository.CandidateFormStatusRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `candidate_form_status` at /api/candidate-form-status. */
@RestController
@RequestMapping("/api/candidate-form-status")
public class CandidateFormStatusController extends BaseCrudController<CandidateFormStatus, Integer> {

    public CandidateFormStatusController(CandidateFormStatusRepository repository) {
        super(repository);
    }
}
