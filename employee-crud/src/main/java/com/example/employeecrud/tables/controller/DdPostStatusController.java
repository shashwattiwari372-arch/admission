package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdPostStatus;
import com.example.employeecrud.tables.repository.DdPostStatusRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_post_status` at /api/dd-post-status. */
@RestController
@RequestMapping("/api/dd-post-status")
public class DdPostStatusController extends BaseCrudController<DdPostStatus, Integer> {

    public DdPostStatusController(DdPostStatusRepository repository) {
        super(repository);
    }
}
