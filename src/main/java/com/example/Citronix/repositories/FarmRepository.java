package com.example.Citronix.repositories;

import com.example.Citronix.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FarmRepository extends JpaRepository<Farm, UUID> {

}
