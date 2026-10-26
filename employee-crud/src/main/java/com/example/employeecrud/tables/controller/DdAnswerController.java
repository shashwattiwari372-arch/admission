package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdAnswer;
import com.example.employeecrud.tables.repository.DdAnswerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_answer` at /api/dd-answer. */
@RestController
@RequestMapping("/api/dd-answer")
public class DdAnswerController extends BaseCrudController<DdAnswer, Integer> {

    public DdAnswerController(DdAnswerRepository repository) {
        super(repository);
    }
}
