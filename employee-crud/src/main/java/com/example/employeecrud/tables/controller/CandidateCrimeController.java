package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.CandidateCrime;
import com.example.employeecrud.tables.repository.CandidateCrimeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `candidate_crime` at /api/candidate-crime. */
@RestController
@RequestMapping("/api/candidate-crime")
public class CandidateCrimeController extends BaseCrudController<CandidateCrime, Integer> {

    public CandidateCrimeController(CandidateCrimeRepository repository) {
        super(repository);
    }
}
