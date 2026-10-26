package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdGender;
import com.example.employeecrud.tables.repository.DdGenderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_gender` at /api/dd-gender. */
@RestController
@RequestMapping("/api/dd-gender")
public class DdGenderController extends BaseCrudController<DdGender, Integer> {

    public DdGenderController(DdGenderRepository repository) {
        super(repository);
    }
}
