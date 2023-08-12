package com.example.edgaresponda300362809.repository;

import com.example.edgaresponda300362809.Component.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<category, String> {
}
