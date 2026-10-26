package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.LegacyAppUser;
import com.example.employeecrud.tables.repository.LegacyAppUserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `app_user` at /api/app-user. */
@RestController
@RequestMapping("/api/app-user")
public class LegacyAppUserController extends BaseCrudController<LegacyAppUser, Integer> {

    public LegacyAppUserController(LegacyAppUserRepository repository) {
        super(repository);
    }
}
