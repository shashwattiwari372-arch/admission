package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.CandidateQuali;
import com.example.employeecrud.tables.repository.CandidateQualiRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `candidate_quali` at /api/candidate-quali. */
@RestController
@RequestMapping("/api/candidate-quali")
public class CandidateQualiController extends BaseCrudController<CandidateQuali, Integer> {

    public CandidateQualiController(CandidateQualiRepository repository) {
        super(repository);
    }
}
