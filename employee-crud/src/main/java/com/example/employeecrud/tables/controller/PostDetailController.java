package com.example.employeecrud.tables.controller;

import com.example.employeecrud.tables.base.BaseCrudController;
import com.example.employeecrud.tables.entity.PostDetail;
import com.example.employeecrud.tables.repository.PostDetailRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CRUD for table `post_detail` at /api/post-detail. */
@RestController
@RequestMapping("/api/post-detail")
public class PostDetailController extends BaseCrudController<PostDetail, Integer> {

    public PostDetailController(PostDetailRepository repository) {
        super(repository);
    }
}
