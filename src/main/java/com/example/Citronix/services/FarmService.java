package com.example.Citronix.services;

import com.example.Citronix.dtos.request.FarmRequestDTO;
import com.example.Citronix.dtos.response.FarmResponseDTO;
import com.example.Citronix.entities.Farm;
import com.example.Citronix.mapper.BaseMapper;
import com.example.Citronix.repositories.FarmRepository;
import com.example.Citronix.repositories.implementation.FarmRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class FarmService implements Services<FarmRequestDTO, FarmResponseDTO> {
    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private BaseMapper<Farm, FarmRequestDTO, FarmResponseDTO> baseMapper;

    @Override
    public Optional<FarmResponseDTO> get(UUID id) {
        Optional<Farm> optionalFarm = farmRepository.findById(id);

        return optionalFarm.map(farm -> baseMapper.toResponseDto(farm));
    }

    @Override
    public List<FarmResponseDTO> getAll() {
        List<Farm> farms = farmRepository.findAll();

        return farms.stream().map(farm -> baseMapper.toResponseDto(farm)).toList();
    }

    @Override
    public boolean save(FarmRequestDTO entity) {
        return false;
    }

    @Override
    public boolean update(FarmRequestDTO entity) {
        return false;
    }

    @Override
    public boolean delete(FarmRequestDTO entity) {
        return false;
    }
}
