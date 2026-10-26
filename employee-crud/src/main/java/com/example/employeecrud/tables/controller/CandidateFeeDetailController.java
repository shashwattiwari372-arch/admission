package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.CandidateFeeDetail;
import com.example.employeecrud.tables.repository.CandidateFeeDetailRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `candidate_fee_detail` at /api/candidate-fee-detail. */
@RestController
@RequestMapping("/api/candidate-fee-detail")
public class CandidateFeeDetailController extends BaseCrudController<CandidateFeeDetail, Integer> {

    public CandidateFeeDetailController(CandidateFeeDetailRepository repository) {
        super(repository);
    }
}
