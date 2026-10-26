package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdTitle;
import com.example.employeecrud.tables.repository.DdTitleRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_title` at /api/dd-title. */
@RestController
@RequestMapping("/api/dd-title")
public class DdTitleController extends BaseCrudController<DdTitle, Integer> {

    public DdTitleController(DdTitleRepository repository) {
        super(repository);
    }
}
