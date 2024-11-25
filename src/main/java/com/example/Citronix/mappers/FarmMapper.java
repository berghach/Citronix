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

    @Mapping(target = "id", ignore = true)
    Farm toEntity ( FarmRequestDTO dto );
    FarmResponseDTO toResponseDto ( Farm entity );
    void updateEntityFromDto(FarmRequestDTO dto, @MappingTarget Farm entity);
}
