package com.example.employeecrud.employee;

import com.example.employeecrud.candidateexp.ResourceNotFoundException;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;
    private final FileStorageService files;

    public EmployeeController(EmployeeService service, FileStorageService files) {
        this.service = service;
        this.files = files;
    }

    @GetMapping
    public List<Employee> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee body) {
        return created(service.create(body, null, null));
    }

    /** multipart: part "employee" (JSON) + optional files "profileImage" and "resume". */
    @PostMapping(value = "/with-files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Employee> createWithFiles(
            @Valid @RequestPart("employee") Employee body,
            @RequestPart(value = "profileImage", required = false) MultipartFile profileImage,
            @RequestPart(value = "resume", required = false) MultipartFile resume) {
        return created(service.create(body, profileImage, resume));
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody Employee body) {
        return service.update(id, body, null, null);
    }

    @PutMapping(value = "/{id}/with-files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Employee updateWithFiles(
            @PathVariable Long id,
            @Valid @RequestPart("employee") Employee body,
            @RequestPart(value = "profileImage", required = false) MultipartFile profileImage,
            @RequestPart(value = "resume", required = false) MultipartFile resume) {
        return service.update(id, body, profileImage, resume);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> file(@PathVariable String filename) {
        Resource r = files.load(filename);
        if (r == null) throw new ResourceNotFoundException("File not found: " + filename);
        MediaType type = MediaTypeFactory.getMediaType(r).orElse(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok()
                .contentType(type)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + filename + "\"")
                .body(r);
    }

    private ResponseEntity<Employee> created(Employee saved) {
        return ResponseEntity.created(URI.create("/api/employees/" + saved.getId())).body(saved);
    }
}
