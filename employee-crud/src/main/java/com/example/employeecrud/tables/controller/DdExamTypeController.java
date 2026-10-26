package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdExamType;
import com.example.employeecrud.tables.repository.DdExamTypeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_exam_type` at /api/dd-exam-type. */
@RestController
@RequestMapping("/api/dd-exam-type")
public class DdExamTypeController extends BaseCrudController<DdExamType, Integer> {

    public DdExamTypeController(DdExamTypeRepository repository) {
        super(repository);
    }
}
