package com.example.Citronix.repositories;

import com.example.Citronix.entities.HarvestDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HarvestDetailRepository extends JpaRepository<HarvestDetail, UUID> {
}
