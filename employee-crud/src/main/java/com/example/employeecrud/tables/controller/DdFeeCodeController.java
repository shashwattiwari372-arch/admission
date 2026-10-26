package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdFeeCode;
import com.example.employeecrud.tables.repository.DdFeeCodeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_fee_code` at /api/dd-fee-code. */
@RestController
@RequestMapping("/api/dd-fee-code")
public class DdFeeCodeController extends BaseCrudController<DdFeeCode, Integer> {

    public DdFeeCodeController(DdFeeCodeRepository repository) {
        super(repository);
    }
}
