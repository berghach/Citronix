package com.example.Citronix.repositories;

import com.example.Citronix.entities.Harvest;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface HarvestRepository extends Repository<Harvest, UUID> {
}
