package com.example.Citronix.services;

import com.example.Citronix.dtos.request.HarvestDetailRequestDTO;
import com.example.Citronix.dtos.response.HarvestDetailResponseDTO;
import com.example.Citronix.entities.HarvestDetail;
import com.example.Citronix.mappers.BaseMapper;
import com.example.Citronix.mappers.HarvestDetailMapper;
import com.example.Citronix.repositories.HarvestDetailRepository;
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
public class HarvestDetailService  implements Services<HarvestDetailRequestDTO, HarvestDetailResponseDTO>{
    private final HarvestDetailRepository harvestDetailRepository;
    private final HarvestDetailMapper harvestDetailMapper;

    @Override
    public Optional<HarvestDetailResponseDTO> get(UUID id) {
        Optional<HarvestDetail> optionalHarvestDetail = harvestDetailRepository.findById(id);

        return optionalHarvestDetail.map(harvestDetailMapper::toResponseDto);
    }

    @Override
    public List<HarvestDetailResponseDTO> getAll() {
        List<HarvestDetail> harvestDetails = harvestDetailRepository.findAll();

        return harvestDetails.stream().map(harvestDetailMapper::toResponseDto).toList();
    }

    @Override
    public HarvestDetailResponseDTO save(HarvestDetailRequestDTO reqEntity) {
        HarvestDetail savedHarvestDetail = harvestDetailRepository.save(harvestDetailMapper.toEntity(reqEntity));
        return harvestDetailMapper.toResponseDto(savedHarvestDetail);
    }

    @Override
    public HarvestDetailResponseDTO update(HarvestDetailRequestDTO reqEntity, UUID oldId) {
        Optional<HarvestDetail> optionalExistingHarvestDetail = harvestDetailRepository.findById(oldId);
        if(optionalExistingHarvestDetail.isPresent()){
            HarvestDetail existingHarvestDetail = optionalExistingHarvestDetail.get();
            harvestDetailMapper.updateEntityFromDto(reqEntity, existingHarvestDetail);
            HarvestDetail updatedHarvestDetail = harvestDetailRepository.save(existingHarvestDetail);
            return harvestDetailMapper.toResponseDto(updatedHarvestDetail);
        }else {
            throw new RuntimeException("Entity not found for update");
        }
    }

    @Override
    public boolean delete(UUID oldId) {
        Optional<HarvestDetail> optionalHarvestDetail = harvestDetailRepository.findById(oldId);
        if (optionalHarvestDetail.isPresent()) {
            harvestDetailRepository.delete(optionalHarvestDetail.get());
            return true;
        } else {
            return false;
        }

    }
}
