package com.example.Citronix.services;

import com.example.Citronix.dtos.request.SaleRequestDTO;
import com.example.Citronix.dtos.response.SaleResponseDTO;
import com.example.Citronix.entities.Sale;
import com.example.Citronix.mappers.SaleMapper;
import com.example.Citronix.repositories.SaleRepository;
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
public class SaleService implements Services<SaleRequestDTO, SaleResponseDTO>{
    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    @Override
    public Optional<SaleResponseDTO> get(UUID id) {
        Optional<Sale> optionalSale = saleRepository.findById(id);

        return optionalSale.map(saleMapper::toResponseDto);
    }

    @Override
    public List<SaleResponseDTO> getAll() {
        List<Sale> sales = saleRepository.findAll();

        return sales.stream().map(saleMapper::toResponseDto).toList();
    }

    @Override
    public SaleResponseDTO save(SaleRequestDTO reqEntity) {
        Sale savedSale = saleRepository.save(saleMapper.toEntity(reqEntity));
        return saleMapper.toResponseDto(savedSale);
    }

    @Override
    public SaleResponseDTO update(SaleRequestDTO reqEntity, UUID oldId) {
        Optional<Sale> optionalExistingSale = saleRepository.findById(oldId);
        if(optionalExistingSale.isPresent()){
            Sale existingSale = optionalExistingSale.get();
            saleMapper.updateEntityFromDto(reqEntity, existingSale);
            Sale updatedSale = saleRepository.save(existingSale);
            return saleMapper.toResponseDto(updatedSale);
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
