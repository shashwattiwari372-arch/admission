package com.example.employeecrud.tables.repository;

import com.example.employeecrud.tables.entity.CandidatePayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatePaymentRepository extends JpaRepository<CandidatePayment, Integer> {
}
