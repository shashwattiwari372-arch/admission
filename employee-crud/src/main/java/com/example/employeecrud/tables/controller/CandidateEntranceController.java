package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.CandidateEntrance;
import com.example.employeecrud.tables.repository.CandidateEntranceRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `candidate_entrance` at /api/candidate-entrance. */
@RestController
@RequestMapping("/api/candidate-entrance")
public class CandidateEntranceController extends BaseCrudController<CandidateEntrance, Integer> {

    public CandidateEntranceController(CandidateEntranceRepository repository) {
        super(repository);
    }
}
