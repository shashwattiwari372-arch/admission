package com.example.employeecrud.state;

import com.example.employeecrud.candidateexp.ResourceNotFoundException;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/states")
public class StateController {

    private final StateRepository repo;

    public StateController(StateRepository repo) { this.repo = repo; }

    @GetMapping
    public List<State> getAll() { return repo.findAllByOrderByValueAsc(); }

    // ---- create / update / delete (the GET above is unchanged) ----

    @GetMapping("/{id}")
    public State getOne(@PathVariable Integer id) { return find(id); }

    @PostMapping
    public ResponseEntity<State> create(@RequestBody State body) {
        check(body);
        body.setId(null);
        State saved = repo.save(body);
        return ResponseEntity.created(URI.create("/api/states/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public State update(@PathVariable Integer id, @RequestBody State body) {
        State existing = find(id);
        check(body);
        existing.setCode(body.getCode().trim());
        existing.setValue(body.getValue().trim());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        repo.delete(find(id));
        return ResponseEntity.noContent().build();
    }

    private State find(Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("State not found with id " + id));
    }

    private void check(State s) {
        if (s.getCode() == null || s.getCode().isBlank()) throw new IllegalArgumentException("Code is required");
        if (s.getValue() == null || s.getValue().isBlank()) throw new IllegalArgumentException("State name is required");
        if (s.getCode().trim().length() > 10) throw new IllegalArgumentException("Code can be at most 10 characters");
        if (s.getValue().trim().length() > 100) throw new IllegalArgumentException("State name can be at most 100 characters");
    }
}
