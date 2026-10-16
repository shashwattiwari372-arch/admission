package com.example.employeecrud.candidateexp;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateExpRepository extends JpaRepository<CandidateExp, Integer> {
    List<CandidateExp> findByAppIdOrderByFromDtDesc(Integer appId);
}
