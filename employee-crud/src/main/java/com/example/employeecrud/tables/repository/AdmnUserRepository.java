package com.example.employeecrud.tables.repository;

import com.example.employeecrud.tables.entity.AdmnUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmnUserRepository extends JpaRepository<AdmnUser, Integer> {
}
