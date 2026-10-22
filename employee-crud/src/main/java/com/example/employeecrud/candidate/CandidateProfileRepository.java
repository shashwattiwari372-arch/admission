package com.example.employeecrud.candidate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile, Integer> {
    boolean existsByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCaseAndIdNot(String email, Integer id);
}
