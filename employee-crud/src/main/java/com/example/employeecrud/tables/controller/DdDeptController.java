package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdDept;
import com.example.employeecrud.tables.repository.DdDeptRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_dept` at /api/dd-dept. */
@RestController
@RequestMapping("/api/dd-dept")
public class DdDeptController extends BaseCrudController<DdDept, Integer> {

    public DdDeptController(DdDeptRepository repository) {
        super(repository);
    }
}
