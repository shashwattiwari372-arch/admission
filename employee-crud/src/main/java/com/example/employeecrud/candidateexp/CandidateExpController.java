package com.example.employeecrud.candidateexp;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidate-exp")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateExpController {

    private final CandidateExpService service;

    public CandidateExpController(CandidateExpService service) {
        this.service = service;
    }

    @GetMapping
    public List<CandidateExp> getAll(@RequestParam(required = false) Integer appId) {
        return appId != null ? service.findByAppId(appId) : service.findAll();
    }

    @GetMapping("/{id}")
    public CandidateExp getOne(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<CandidateExp> create(@Valid @RequestBody CandidateExp body) {
        CandidateExp saved = service.create(body);
        return ResponseEntity.created(URI.create("/api/candidate-exp/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public CandidateExp update(@PathVariable Integer id, @Valid @RequestBody CandidateExp body) {
        return service.update(id, body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
