package com.example.employeecrud.state;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
    List<State> findAllByOrderByValueAsc();
}
