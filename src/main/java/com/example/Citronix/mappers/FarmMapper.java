package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.FarmRequestDTO;
import com.example.Citronix.dtos.response.FarmResponseDTO;
import com.example.Citronix.entities.Farm;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface FarmMapper {
    FarmMapper INSTANCE = Mappers.getMapper(FarmMapper.class);

    Farm toEntity ( FarmRequestDTO dto );
    @Mapping(target = "id", source = "id")
    FarmResponseDTO toResponseDto ( Farm entity );
    void updateEntityFromDto(FarmRequestDTO dto, @MappingTarget Farm entity);
}
