package com.example.employeecrud.candidate;

import com.example.employeecrud.candidateexp.CandidateExpRepository;
import com.example.employeecrud.candidateexp.ResourceNotFoundException;
import com.example.employeecrud.common.ConflictException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateProfileService {

    private final CandidateProfileRepository repo;
    private final CandidateExpRepository expRepo;

    public CandidateProfileService(CandidateProfileRepository repo, CandidateExpRepository expRepo) {
        this.repo = repo;
        this.expRepo = expRepo;
    }

    @Transactional(readOnly = true)
    public List<CandidateProfile> findAll() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Transactional(readOnly = true)
    public CandidateProfile findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id " + id));
    }

    public CandidateProfile create(CandidateProfile c) {
        c.setId(null);
        if (repo.existsByEmailIgnoreCase(c.getEmail().trim())) {
            throw new ConflictException("A candidate with this email already exists.");
        }
        audit(c);
        return repo.save(c);
    }

    public CandidateProfile update(Integer id, CandidateProfile incoming) {
        CandidateProfile existing = findById(id);
        if (repo.existsByEmailIgnoreCaseAndIdNot(incoming.getEmail().trim(), id)) {
            throw new ConflictException("A candidate with this email already exists.");
        }
        // id and the verification / payment columns can never be changed from the form
        BeanUtils.copyProperties(incoming, existing, "id",
                "vStatus", "vBy", "vStamp", "pStatus", "pBy", "pStamp",
                "VStatus", "VBy", "VStamp", "PStatus", "PBy", "PStamp");
        audit(existing);
        return repo.save(existing);
    }

    public void delete(Integer id) {
        CandidateProfile c = findById(id);
        // experience rows are linked by appId = candidate id, so remove them together
        expRepo.deleteAll(expRepo.findByAppIdOrderByFromDtDesc(id));
        repo.delete(c);
    }

    private void audit(CandidateProfile c) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        c.setUpdateBy(auth != null ? auth.getName() : "system");
        c.setUpdateDt(LocalDate.now());
        c.setUpdateTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
