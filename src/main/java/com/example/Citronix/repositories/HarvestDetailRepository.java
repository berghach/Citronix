package com.example.Citronix.repositories;

import com.example.Citronix.entities.HarvestDetail;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface HarvestDetailRepository extends Repository<HarvestDetail, UUID> {
}
