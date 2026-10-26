package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdPayStatus;
import com.example.employeecrud.tables.repository.DdPayStatusRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_pay_status` at /api/dd-pay-status. */
@RestController
@RequestMapping("/api/dd-pay-status")
public class DdPayStatusController extends BaseCrudController<DdPayStatus, Integer> {

    public DdPayStatusController(DdPayStatusRepository repository) {
        super(repository);
    }
}
