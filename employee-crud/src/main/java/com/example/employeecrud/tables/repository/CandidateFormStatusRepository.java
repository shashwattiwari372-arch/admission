package com.example.employeecrud.tables.repository;

import com.example.employeecrud.tables.entity.CandidateFormStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateFormStatusRepository extends JpaRepository<CandidateFormStatus, Integer> {
}
