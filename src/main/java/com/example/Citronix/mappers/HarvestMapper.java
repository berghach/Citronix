package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.HarvestRequestDTO;
import com.example.Citronix.dtos.response.HarvestResponseDTO;
import com.example.Citronix.entities.Harvest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HarvestMapper {
    HarvestMapper INSTANCE = Mappers.getMapper(HarvestMapper.class);

    @Mapping(target = "id", ignore = true)
    Harvest toEntity ( HarvestRequestDTO dto );
    HarvestResponseDTO toResponseDto ( Harvest entity );
    void updateEntityFromDto(HarvestRequestDTO dto, @MappingTarget Harvest entity);
}
