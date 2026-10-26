package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdFormStatus;
import com.example.employeecrud.tables.repository.DdFormStatusRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_form_status` at /api/dd-form-status. */
@RestController
@RequestMapping("/api/dd-form-status")
public class DdFormStatusController extends BaseCrudController<DdFormStatus, Integer> {

    public DdFormStatusController(DdFormStatusRepository repository) {
        super(repository);
    }
}
