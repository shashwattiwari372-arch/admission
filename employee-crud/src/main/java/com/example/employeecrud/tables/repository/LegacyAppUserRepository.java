package com.example.employeecrud.tables.repository;

import com.example.employeecrud.tables.entity.LegacyAppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegacyAppUserRepository extends JpaRepository<LegacyAppUser, Integer> {
}
