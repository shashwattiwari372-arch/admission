package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.CandidateAppMaster;
import com.example.employeecrud.tables.repository.CandidateAppMasterRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `candidate_app_master` at /api/candidate-app-master. */
@RestController
@RequestMapping("/api/candidate-app-master")
public class CandidateAppMasterController extends BaseCrudController<CandidateAppMaster, Integer> {

    public CandidateAppMasterController(CandidateAppMasterRepository repository) {
        super(repository);
    }
}
