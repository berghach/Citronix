package com.example.Citronix.repositories;

import com.example.Citronix.entities.Field;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface FieldRepository extends Repository<Field, UUID> {
}
