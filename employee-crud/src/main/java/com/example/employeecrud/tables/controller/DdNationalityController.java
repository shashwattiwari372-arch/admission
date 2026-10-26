package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdNationality;
import com.example.employeecrud.tables.repository.DdNationalityRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_nationality` at /api/dd-nationality. */
@RestController
@RequestMapping("/api/dd-nationality")
public class DdNationalityController extends BaseCrudController<DdNationality, Integer> {

    public DdNationalityController(DdNationalityRepository repository) {
        super(repository);
    }
}
