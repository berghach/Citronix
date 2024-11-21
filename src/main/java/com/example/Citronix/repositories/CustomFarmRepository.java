package com.example.Citronix.repositories;

import com.example.Citronix.entities.Farm;

import java.time.LocalDate;
import java.util.List;

public interface CustomFarmRepository {
    List<Farm> findByCriteria(String name, String location, LocalDate date);
}
