package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdState;
import com.example.employeecrud.tables.repository.DdStateRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_state` at /api/dd-state. */
@RestController
@RequestMapping("/api/dd-state")
public class DdStateController extends BaseCrudController<DdState, Integer> {

    public DdStateController(DdStateRepository repository) {
        super(repository);
    }
}
