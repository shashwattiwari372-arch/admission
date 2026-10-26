package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.CandidateTraining;
import com.example.employeecrud.tables.repository.CandidateTrainingRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `candidate_training` at /api/candidate-training. */
@RestController
@RequestMapping("/api/candidate-training")
public class CandidateTrainingController extends BaseCrudController<CandidateTraining, Integer> {

    public CandidateTrainingController(CandidateTrainingRepository repository) {
        super(repository);
    }
}
