package com.example.Citronix.services;

import com.example.Citronix.dtos.request.FieldRequestDTO;
import com.example.Citronix.dtos.response.FieldResponseDTO;
import com.example.Citronix.entities.Field;
import com.example.Citronix.mappers.FieldMapper;
import com.example.Citronix.repositories.FieldRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class FieldService implements Services<FieldRequestDTO, FieldResponseDTO>{
    private final FieldRepository fieldRepository;
    private final FieldMapper fieldMapper;

    @Override
    public Optional<FieldResponseDTO> get(UUID id) {
        Optional<Field> optionalField = fieldRepository.findById(id);

        return optionalField.map(fieldMapper::toResponseDto);
    }

    @Override
    public List<FieldResponseDTO> getAll() {
        List<Field> fields = fieldRepository.findAll();

        return fields.stream().map(fieldMapper::toResponseDto).toList();
    }

    @Override
    public FieldResponseDTO save(FieldRequestDTO reqEntity) {
        Field savedField = fieldRepository.save(fieldMapper.toEntity(reqEntity));
        return fieldMapper.toResponseDto(savedField);
    }

    @Override
    public FieldResponseDTO update(FieldRequestDTO reqEntity, UUID oldId) {
        Optional<Field> optionalExistingField = fieldRepository.findById(oldId);
        if(optionalExistingField.isPresent()){
            Field existingField = optionalExistingField.get();
            fieldMapper.updateEntityFromDto(reqEntity, existingField);
            Field updatedField = fieldRepository.save(existingField);
            return fieldMapper.toResponseDto(updatedField);
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
