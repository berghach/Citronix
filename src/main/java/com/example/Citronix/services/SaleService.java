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
        Optional<Sale> optionalSale = saleRepository.findById(id);

        return optionalSale.map(sale -> baseMapper.toResponseDto(sale));
    }

    @Override
    public List<SaleResponseDTO> getAll() {
        List<Sale> sales = saleRepository.findAll();

        return sales.stream().map(sale -> baseMapper.toResponseDto(sale)).toList();
    }

    @Override
    public SaleResponseDTO save(SaleRequestDTO reqEntity) {
        Sale savedSale = saleRepository.save(baseMapper.toEntity(reqEntity));
        return baseMapper.toResponseDto(savedSale);
    }

    @Override
    public SaleResponseDTO update(SaleRequestDTO reqEntity, UUID oldId) {
        Optional<Sale> optionalExistingSale = saleRepository.findById(oldId);
        if(optionalExistingSale.isPresent()){
            Sale existingSale = optionalExistingSale.get();
            baseMapper.updateEntityFromDto(reqEntity, existingSale);
            Sale updatedSale = saleRepository.save(existingSale);
            return baseMapper.toResponseDto(updatedSale);
        }else {
            throw new RuntimeException("Entity not found for update");
        }
    }

    @Override
    public boolean delete(UUID oldId) {
        Optional<Sale> optionalSale = saleRepository.findById(oldId);
        if (optionalSale.isPresent()) {
            saleRepository.delete(optionalSale.get());
            return true;
        } else {
            return false;
        }

    }
}
