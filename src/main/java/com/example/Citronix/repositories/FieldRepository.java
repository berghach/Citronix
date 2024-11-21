package com.example.Citronix.repositories;

import com.example.Citronix.entities.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FieldRepository extends JpaRepository<Field, UUID> {
}
