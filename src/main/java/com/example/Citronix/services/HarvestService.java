package com.example.Citronix.services;

import com.example.Citronix.dtos.request.HarvestRequestDTO;
import com.example.Citronix.dtos.response.HarvestResponseDTO;
import com.example.Citronix.entities.Harvest;
import com.example.Citronix.mappers.BaseMapper;
import com.example.Citronix.mappers.HarvestMapper;
import com.example.Citronix.repositories.HarvestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class HarvestService implements Services<HarvestRequestDTO, HarvestResponseDTO>{
    private final HarvestRepository harvestRepository;
    private final HarvestMapper harvestMapper;

    @Override
    public Optional<HarvestResponseDTO> get(UUID id) {
        Optional<Harvest> optionalHarvest = harvestRepository.findById(id);

        return optionalHarvest.map(harvestMapper::toResponseDto);
    }

    @Override
    public List<HarvestResponseDTO> getAll() {
        List<Harvest> harvests = harvestRepository.findAll();

        return harvests.stream().map(harvestMapper::toResponseDto).toList();
    }

    @Override
    public HarvestResponseDTO save(HarvestRequestDTO reqEntity) {
        Harvest savedHarvest = harvestRepository.save(harvestMapper.toEntity(reqEntity));
        return harvestMapper.toResponseDto(savedHarvest);
    }

    @Override
    public HarvestResponseDTO update(HarvestRequestDTO reqEntity, UUID oldId) {
        Optional<Harvest> optionalExistingHarvest = harvestRepository.findById(oldId);
        if(optionalExistingHarvest.isPresent()){
            Harvest existingHarvest = optionalExistingHarvest.get();
            harvestMapper.updateEntityFromDto(reqEntity, existingHarvest);
            Harvest updatedHarvest = harvestRepository.save(existingHarvest);
            return harvestMapper.toResponseDto(updatedHarvest);
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
