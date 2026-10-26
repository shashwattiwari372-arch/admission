package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdJobType;
import com.example.employeecrud.tables.repository.DdJobTypeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_job_type` at /api/dd-job-type. */
@RestController
@RequestMapping("/api/dd-job-type")
public class DdJobTypeController extends BaseCrudController<DdJobType, Integer> {

    public DdJobTypeController(DdJobTypeRepository repository) {
        super(repository);
    }
}
