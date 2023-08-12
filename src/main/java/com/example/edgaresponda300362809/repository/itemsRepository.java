package com.example.edgaresponda300362809.repository;

import com.example.edgaresponda300362809.Component.items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemsRepository extends JpaRepository<items, String> {
}
