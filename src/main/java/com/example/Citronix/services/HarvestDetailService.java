package com.example.Citronix.services;

import com.example.Citronix.dtos.request.HarvestDetailRequestDTO;
import com.example.Citronix.dtos.response.HarvestDetailResponseDTO;
import com.example.Citronix.entities.HarvestDetail;
import com.example.Citronix.mapper.BaseMapper;
import com.example.Citronix.repositories.HarvestDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HarvestDetailService  implements Services<HarvestDetailRequestDTO, HarvestDetailResponseDTO>{
    @Autowired
    private HarvestDetailRepository harvestDetailRepository;

    @Autowired
    private BaseMapper<HarvestDetail, HarvestDetailRequestDTO, HarvestDetailResponseDTO> baseMapper;

    @Override
    public Optional<HarvestDetailResponseDTO> get(UUID id) {
        Optional<HarvestDetail> optionalHarvestDetail = harvestDetailRepository.findById(id);

        return optionalHarvestDetail.map(harvestDetail -> baseMapper.toResponseDto(harvestDetail));
    }

    @Override
    public List<HarvestDetailResponseDTO> getAll() {
        List<HarvestDetail> harvestDetails = harvestDetailRepository.findAll();

        return harvestDetails.stream().map(harvestDetail -> baseMapper.toResponseDto(harvestDetail)).toList();
    }

    @Override
    public HarvestDetailResponseDTO save(HarvestDetailRequestDTO reqEntity) {
        HarvestDetail savedHarvestDetail = harvestDetailRepository.save(baseMapper.toEntity(reqEntity));
        return baseMapper.toResponseDto(savedHarvestDetail);
    }

    @Override
    public HarvestDetailResponseDTO update(HarvestDetailRequestDTO reqEntity, UUID oldId) {
        Optional<HarvestDetail> optionalExistingHarvestDetail = harvestDetailRepository.findById(oldId);
        if(optionalExistingHarvestDetail.isPresent()){
            HarvestDetail existingHarvestDetail = optionalExistingHarvestDetail.get();
            baseMapper.updateEntityFromDto(reqEntity, existingHarvestDetail);
            HarvestDetail updatedHarvestDetail = harvestDetailRepository.save(existingHarvestDetail);
            return baseMapper.toResponseDto(updatedHarvestDetail);
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
