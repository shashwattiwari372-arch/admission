package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdMaritalStatus;
import com.example.employeecrud.tables.repository.DdMaritalStatusRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_marital_status` at /api/dd-marital-status. */
@RestController
@RequestMapping("/api/dd-marital-status")
public class DdMaritalStatusController extends BaseCrudController<DdMaritalStatus, Integer> {

    public DdMaritalStatusController(DdMaritalStatusRepository repository) {
        super(repository);
    }
}
