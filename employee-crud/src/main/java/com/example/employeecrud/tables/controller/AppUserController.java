package com.example.employeecrud.tables.controller;

import com.example.employeecrud.auth.AppUser;
import com.example.employeecrud.auth.AppUserRepository;
import com.example.employeecrud.candidateexp.ResourceNotFoundException;
import com.example.employeecrud.common.ConflictException;
import java.net.URI;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** CRUD for table `app_users` (the accounts that can sign in) at /api/app-users. */
@RestController
@RequestMapping("/api/app-users")
public class AppUserController {

    private final AppUserRepository repository;

    public AppUserController(AppUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AppUser> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @GetMapping("/{id}")
    public AppUser getOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Login user not found with id " + id));
    }

    @PostMapping
    public ResponseEntity<AppUser> create(@RequestBody AppUser body) {
        check(body, null);
        body.setId(null);
        AppUser saved = repository.save(body);
        return ResponseEntity.created(URI.create("/api/app-users/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public AppUser update(@PathVariable Long id, @RequestBody AppUser body) {
        AppUser existing = getOne(id);
        check(body, id);
        existing.setUsername(body.getUsername().trim());
        existing.setPassword(body.getPassword());
        existing.setFullName(body.getFullName());
        existing.setEmail(body.getEmail());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.delete(getOne(id));
        return ResponseEntity.noContent().build();
    }

    private void check(AppUser u, Long selfId) {
        if (u.getUsername() == null || u.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username is required");
        }
        if (u.getUsername().trim().length() > 80) {
            throw new IllegalArgumentException("Username can be at most 80 characters");
        }
        if (u.getPassword() == null || u.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
        repository.findByUsernameIgnoreCase(u.getUsername().trim()).ifPresent(other -> {
            if (!other.getId().equals(selfId)) {
                throw new ConflictException("This username is already taken.");
            }
        });
    }
}
