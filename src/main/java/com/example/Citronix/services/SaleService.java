package com.example.Citronix.services;

import com.example.Citronix.dtos.request.SaleRequestDTO;
import com.example.Citronix.dtos.response.SaleResponseDTO;
import com.example.Citronix.entities.Sale;
import com.example.Citronix.mapper.BaseMapper;
import com.example.Citronix.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SaleService implements Services<SaleRequestDTO, SaleResponseDTO>{
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private BaseMapper<Sale, SaleRequestDTO, SaleResponseDTO> baseMapper;

    @Override
    public Optional<SaleResponseDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<SaleResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public boolean save(SaleRequestDTO entity) {
        return false;
    }

    @Override
    public boolean update(SaleRequestDTO entity) {
        return false;
    }

    @Override
    public boolean delete(SaleRequestDTO entity) {
        return false;
    }
}
