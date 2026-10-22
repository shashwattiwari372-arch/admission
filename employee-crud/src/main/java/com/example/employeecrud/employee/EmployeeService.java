package com.example.employeecrud.employee;

import com.example.employeecrud.candidateexp.ResourceNotFoundException;
import com.example.employeecrud.common.ConflictException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repo;
    private final PasswordEncoder encoder;
    private final FileStorageService files;

    public EmployeeService(EmployeeRepository repo, PasswordEncoder encoder, FileStorageService files) {
        this.repo = repo;
        this.encoder = encoder;
        this.files = files;
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Transactional(readOnly = true)
    public Employee findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    public Employee create(Employee e, MultipartFile image, MultipartFile resume) {
        e.setId(null);
        e.setEmail(e.getEmail().trim());
        if (repo.existsByEmailIgnoreCase(e.getEmail())) {
            throw new ConflictException("An employee with this email already exists.");
        }
        if (e.getPassword() == null || e.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password is required (min 6 characters).");
        }
        e.setPassword(encoder.encode(e.getPassword()));
        e.setProfileImage(null);
        e.setResume(null);
        attach(e, image, resume);
        return repo.save(e);
    }

    public Employee update(Long id, Employee in, MultipartFile image, MultipartFile resume) {
        Employee e = findById(id);
        String email = in.getEmail().trim();
        if (repo.existsByEmailIgnoreCaseAndIdNot(email, id)) {
            throw new ConflictException("An employee with this email already exists.");
        }
        e.setFullName(in.getFullName());
        e.setEmail(email);
        e.setAge(in.getAge());
        e.setGender(in.getGender());
        e.setDepartment(in.getDepartment());
        e.setSkills(in.getSkills());
        e.setEmploymentType(in.getEmploymentType());
        e.setActive(in.getActive());
        e.setJoiningDate(in.getJoiningDate());
        e.setAddress(in.getAddress());
        // blank password = keep the current one (the edit form leaves it empty)
        if (in.getPassword() != null && !in.getPassword().isBlank()) {
            if (in.getPassword().length() < 6) {
                throw new IllegalArgumentException("Use at least 6 characters for the password.");
            }
            e.setPassword(encoder.encode(in.getPassword()));
        }
        attach(e, image, resume);
        return repo.save(e);
    }

    public void delete(Long id) {
        Employee e = findById(id);
        files.deleteQuietly(e.getProfileImage());
        files.deleteQuietly(e.getResume());
        repo.delete(e);
    }

    /** Stores new files and removes the ones they replace. */
    private void attach(Employee e, MultipartFile image, MultipartFile resume) {
        if (image != null && !image.isEmpty()) {
            String old = e.getProfileImage();
            e.setProfileImage(files.store(image));
            files.deleteQuietly(old);
        }
        if (resume != null && !resume.isEmpty()) {
            String old = e.getResume();
            e.setResume(files.store(resume));
            files.deleteQuietly(old);
        }
    }
}
