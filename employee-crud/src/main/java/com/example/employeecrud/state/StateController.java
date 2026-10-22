package com.example.employeecrud.state;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/states")
public class StateController {

    private final StateRepository repo;

    public StateController(StateRepository repo) { this.repo = repo; }

    @GetMapping
    public List<State> getAll() { return repo.findAllByOrderByValueAsc(); }
}
