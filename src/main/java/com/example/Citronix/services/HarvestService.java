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
        Optional<Harvest> optionalHarvest = harvestRepository.findById(id);

        return optionalHarvest.map(harvest -> baseMapper.toResponseDto(harvest));
    }

    @Override
    public List<HarvestResponseDTO> getAll() {
        List<Harvest> harvests = harvestRepository.findAll();

        return harvests.stream().map(harvest -> baseMapper.toResponseDto(harvest)).toList();
    }

    @Override
    public HarvestResponseDTO save(HarvestRequestDTO reqEntity) {
        Harvest savedHarvest = harvestRepository.save(baseMapper.toEntity(reqEntity));
        return baseMapper.toResponseDto(savedHarvest);
    }

    @Override
    public HarvestResponseDTO update(HarvestRequestDTO reqEntity, UUID oldId) {
        Optional<Harvest> optionalExistingHarvest = harvestRepository.findById(oldId);
        if(optionalExistingHarvest.isPresent()){
            Harvest existingHarvest = optionalExistingHarvest.get();
            baseMapper.updateEntityFromDto(reqEntity, existingHarvest);
            Harvest updatedHarvest = harvestRepository.save(existingHarvest);
            return baseMapper.toResponseDto(updatedHarvest);
        }else {
            throw new RuntimeException("Entity not found for update");
        }
    }

    @Override
    public boolean delete(UUID oldId) {
        Optional<Harvest> optionalHarvest = harvestRepository.findById(oldId);
        if (optionalHarvest.isPresent()) {
            harvestRepository.delete(optionalHarvest.get());
            return true;
        } else {
            return false;
        }
    }
}
