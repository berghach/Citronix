package com.example.Citronix.services;

import com.example.Citronix.dtos.request.FieldRequestDTO;
import com.example.Citronix.dtos.response.FieldResponseDTO;
import com.example.Citronix.entities.Field;
import com.example.Citronix.mapper.BaseMapper;
import com.example.Citronix.repositories.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FieldService implements Services<FieldRequestDTO, FieldResponseDTO>{
    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private BaseMapper<Field, FieldRequestDTO, FieldResponseDTO> baseMapper;

    @Override
    public Optional<FieldResponseDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<FieldResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public boolean save(FieldRequestDTO entity) {
        return false;
    }

    @Override
    public boolean update(FieldRequestDTO entity) {
        return false;
    }

    @Override
    public boolean delete(FieldRequestDTO entity) {
        return false;
    }
}
