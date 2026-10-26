package com.example.employeecrud.tables.repository;

import com.example.employeecrud.tables.entity.DdCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DdCategoryRepository extends JpaRepository<DdCategory, Integer> {
}
