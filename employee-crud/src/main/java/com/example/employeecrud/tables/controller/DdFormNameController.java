package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdFormName;
import com.example.employeecrud.tables.repository.DdFormNameRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_form_name` at /api/dd-form-name. */
@RestController
@RequestMapping("/api/dd-form-name")
public class DdFormNameController extends BaseCrudController<DdFormName, Integer> {

    public DdFormNameController(DdFormNameRepository repository) {
        super(repository);
    }
}
