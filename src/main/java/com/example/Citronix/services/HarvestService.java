package com.example.Citronix.services;

import com.example.Citronix.dtos.request.HarvestRequestDTO;
import com.example.Citronix.dtos.response.HarvestResponseDTO;
import com.example.Citronix.entities.Harvest;
import com.example.Citronix.mapper.BaseMapper;
import com.example.Citronix.repositories.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HarvestService implements Services<HarvestRequestDTO, HarvestResponseDTO>{
    @Autowired
    private HarvestRepository harvestRepository;
    
    @Autowired
    private BaseMapper<Harvest, HarvestRequestDTO, HarvestResponseDTO> baseMapper;

    @Override
    public Optional<HarvestResponseDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<HarvestResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public boolean save(HarvestRequestDTO entity) {
        return false;
    }

    @Override
    public boolean update(HarvestRequestDTO entity) {
        return false;
    }

    @Override
    public boolean delete(HarvestRequestDTO entity) {
        return false;
    }
}
