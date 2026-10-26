package com.example.employeecrud.tables.base;

import com.example.employeecrud.candidateexp.ResourceNotFoundException;
import jakarta.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * GET list, GET one, POST, PUT and DELETE for one table.
 * A subclass only adds @RestController + @RequestMapping("/api/...") and passes its repository.
 */
public abstract class BaseCrudController<T extends TableEntity<ID>, ID> {

    private final JpaRepository<T, ID> repository;

    protected BaseCrudController(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<T> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @GetMapping("/{id}")
    public T getOne(@PathVariable ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found with id " + id));
    }

    @PostMapping
    public ResponseEntity<T> create(@Valid @RequestBody T body) {
        body.setId(null);
        stamp(body);
        T saved = repository.save(body);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @Valid @RequestBody T body) {
        T existing = getOne(id);
        BeanUtils.copyProperties(body, existing, "id");
        stamp(existing);
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        repository.delete(getOne(id));
        return ResponseEntity.noContent().build();
    }

    private void stamp(T entity) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        entity.stamp(auth != null ? auth.getName() : "system", LocalDate.now(), LocalTime.now().withNano(0));
    }
}
