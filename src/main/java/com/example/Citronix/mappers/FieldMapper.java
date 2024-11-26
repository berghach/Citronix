package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.FieldRequestDTO;
import com.example.Citronix.dtos.response.FieldResponseDTO;
import com.example.Citronix.entities.Field;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FieldMapper {
    FieldMapper INSTANCE = Mappers.getMapper(FieldMapper.class);

    Field toEntity (FieldRequestDTO dto );
    //@Mapping(target = "id", source = "id")
    FieldResponseDTO toResponseDto (Field entity );
    void updateEntityFromDto(FieldRequestDTO dto, @MappingTarget Field entity);
}
