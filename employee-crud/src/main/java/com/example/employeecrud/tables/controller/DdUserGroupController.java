package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.DdUserGroup;
import com.example.employeecrud.tables.repository.DdUserGroupRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `dd_user_group` at /api/dd-user-group. */
@RestController
@RequestMapping("/api/dd-user-group")
public class DdUserGroupController extends BaseCrudController<DdUserGroup, Integer> {

    public DdUserGroupController(DdUserGroupRepository repository) {
        super(repository);
    }
}
