package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdCategory;
import com.example.employeecrud.tables.repository.DdCategoryRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_category` at /api/dd-category. */
@RestController
@RequestMapping("/api/dd-category")
public class DdCategoryController extends BaseCrudController<DdCategory, Integer> {

    public DdCategoryController(DdCategoryRepository repository) {
        super(repository);
    }
}
