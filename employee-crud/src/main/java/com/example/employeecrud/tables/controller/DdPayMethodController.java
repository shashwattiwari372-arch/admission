package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdPayMethod;
import com.example.employeecrud.tables.repository.DdPayMethodRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_pay_method` at /api/dd-pay-method. */
@RestController
@RequestMapping("/api/dd-pay-method")
public class DdPayMethodController extends BaseCrudController<DdPayMethod, Integer> {

    public DdPayMethodController(DdPayMethodRepository repository) {
        super(repository);
    }
}
