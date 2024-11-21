package com.example.Citronix.repositories.implementation;

import com.example.Citronix.repositories.CustomFarmRepository;
import com.example.Citronix.repositories.FarmRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FarmRepositoryImpl implements FarmRepository, CustomFarmRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List findByCriteria() {
        return List.of();
    }
}
