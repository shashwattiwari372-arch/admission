package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.CandidateEnclosures;
import com.example.employeecrud.tables.repository.CandidateEnclosuresRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `candidate_enclosures` at /api/candidate-enclosures. */
@RestController
@RequestMapping("/api/candidate-enclosures")
public class CandidateEnclosuresController extends BaseCrudController<CandidateEnclosures, Integer> {

    public CandidateEnclosuresController(CandidateEnclosuresRepository repository) {
        super(repository);
    }
}
