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
        return Optional.empty();
    }

    @Override
    public List<HarvestDetailResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public boolean save(HarvestDetailRequestDTO entity) {
        return false;
    }

    @Override
    public boolean update(HarvestDetailRequestDTO entity) {
        return false;
    }

    @Override
    public boolean delete(HarvestDetailRequestDTO entity) {
        return false;
    }
}
