package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.MasterConfig;
import com.example.employeecrud.tables.repository.MasterConfigRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `master_config` at /api/master-config. */
@RestController
@RequestMapping("/api/master-config")
public class MasterConfigController extends BaseCrudController<MasterConfig, Long> {

    public MasterConfigController(MasterConfigRepository repository) {
        super(repository);
    }
}
