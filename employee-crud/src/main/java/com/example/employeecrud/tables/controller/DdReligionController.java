package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdReligion;
import com.example.employeecrud.tables.repository.DdReligionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_religion` at /api/dd-religion. */
@RestController
@RequestMapping("/api/dd-religion")
public class DdReligionController extends BaseCrudController<DdReligion, Integer> {

    public DdReligionController(DdReligionRepository repository) {
        super(repository);
    }
}
