package com.example.Citronix.repositories;

import com.example.Citronix.entities.Farm;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface FarmRepository extends Repository<Farm, UUID> {

}
