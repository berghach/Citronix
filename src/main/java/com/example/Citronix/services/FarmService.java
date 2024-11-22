package com.example.Citronix.services;

import com.example.Citronix.dtos.request.FarmRequestDTO;
import com.example.Citronix.dtos.response.FarmResponseDTO;
import com.example.Citronix.entities.Farm;
import com.example.Citronix.mappers.BaseMapper;
import com.example.Citronix.mappers.FarmMapper;
import com.example.Citronix.repositories.FarmRepository;
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
public class FarmService implements Services<FarmRequestDTO, FarmResponseDTO> {

    private final FarmRepository farmRepository;
    private final FarmMapper farmMapper;

    @Override
    public Optional<FarmResponseDTO> get(UUID id) {
        Optional<Farm> optionalFarm = farmRepository.findById(id);

        return optionalFarm.map(farmMapper::toResponseDto);
    }

    @Override
    public List<FarmResponseDTO> getAll() {
        List<Farm> farms = farmRepository.findAll();

        return farms.stream().map(farmMapper::toResponseDto).toList();
    }

    @Override
    public FarmResponseDTO save(FarmRequestDTO reqEntity) {
        Farm savedFarm = farmRepository.save(farmMapper.toEntity(reqEntity));
        return farmMapper.toResponseDto(savedFarm);
    }

    @Override
    public FarmResponseDTO update(FarmRequestDTO reqEntity, UUID oldId) {
        Optional<Farm> optionalExistingFarm = farmRepository.findById(oldId);
        if(optionalExistingFarm.isPresent()){
            Farm existingFarm = optionalExistingFarm.get();
            farmMapper.updateEntityFromDto(reqEntity, existingFarm);
            Farm updatedFarm = farmRepository.save(existingFarm);
            return farmMapper.toResponseDto(updatedFarm);
        }else {
            throw new RuntimeException("Entity not found for update");
        }
    }

    @Override
    public boolean delete(UUID oldId) {
        Optional<Farm> optionalFarm = farmRepository.findById(oldId);
        if (optionalFarm.isPresent()) {
            farmRepository.delete(optionalFarm.get());
            return true;
        } else {
            return false;
        }
    }
}
