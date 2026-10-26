package com.example.employeecrud.tables.repository;

import com.example.employeecrud.tables.entity.CandidateAppMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateAppMasterRepository extends JpaRepository<CandidateAppMaster, Integer> {
}
