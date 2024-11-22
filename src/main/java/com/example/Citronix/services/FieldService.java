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
        Optional<Field> optionalField = fieldRepository.findById(id);

        return optionalField.map(field -> baseMapper.toResponseDto(field));
    }

    @Override
    public List<FieldResponseDTO> getAll() {
        List<Field> fields = fieldRepository.findAll();

        return fields.stream().map(field -> baseMapper.toResponseDto(field)).toList();
    }

    @Override
    public FieldResponseDTO save(FieldRequestDTO reqEntity) {
        Field savedField = fieldRepository.save(baseMapper.toEntity(reqEntity));
        return baseMapper.toResponseDto(savedField);
    }

    @Override
    public FieldResponseDTO update(FieldRequestDTO reqEntity, UUID oldId) {
        Optional<Field> optionalExistingField = fieldRepository.findById(oldId);
        if(optionalExistingField.isPresent()){
            Field existingField = optionalExistingField.get();
            baseMapper.updateEntityFromDto(reqEntity, existingField);
            Field updatedField = fieldRepository.save(existingField);
            return baseMapper.toResponseDto(updatedField);
        }else {
            throw new RuntimeException("Entity not found for update");
        }
    }

    @Override
    public boolean delete(UUID oldId) {
        Optional<Field> optionalField = fieldRepository.findById(oldId);
        if (optionalField.isPresent()) {
            fieldRepository.delete(optionalField.get());
            return true;
        } else {
            return false;
        }
    }
}
