package com.example.employeecrud.candidate;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
public class CandidateProfileController {

    private final CandidateProfileService service;

    public CandidateProfileController(CandidateProfileService service) {
        this.service = service;
    }

    @GetMapping
    public List<CandidateProfile> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public CandidateProfile getOne(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<CandidateProfile> create(@Valid @RequestBody CandidateProfile body) {
        CandidateProfile saved = service.create(body);
        return ResponseEntity.created(URI.create("/api/candidates/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public CandidateProfile update(@PathVariable Integer id, @Valid @RequestBody CandidateProfile body) {
        return service.update(id, body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
