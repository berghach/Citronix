package com.example.Citronix.repositories;

import com.example.Citronix.entities.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HarvestRepository extends JpaRepository<Harvest, UUID> {
}
