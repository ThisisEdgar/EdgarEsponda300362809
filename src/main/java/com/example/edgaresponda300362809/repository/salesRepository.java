package com.example.edgaresponda300362809.repository;

import com.example.edgaresponda300362809.Component.sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface salesRepository extends JpaRepository<sales, Long> {
    }

