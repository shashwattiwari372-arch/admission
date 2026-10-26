package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.AdmnUser;
import com.example.employeecrud.tables.repository.AdmnUserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `admn_user` at /api/admn-user. */
@RestController
@RequestMapping("/api/admn-user")
public class AdmnUserController extends BaseCrudController<AdmnUser, Integer> {

    public AdmnUserController(AdmnUserRepository repository) {
        super(repository);
    }
}
