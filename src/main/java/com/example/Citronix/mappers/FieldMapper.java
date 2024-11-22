package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.FieldRequestDTO;
import com.example.Citronix.dtos.response.FieldResponseDTO;
import com.example.Citronix.entities.Field;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface FieldMapper extends BaseMapper<Field, FieldRequestDTO, FieldResponseDTO>{
}
