package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.HarvestDetailRequestDTO;
import com.example.Citronix.dtos.response.HarvestDetailResponseDTO;
import com.example.Citronix.entities.HarvestDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HarvestDetailMapper {
    HarvestDetailMapper INSTANCE = Mappers.getMapper(HarvestDetailMapper.class);

    HarvestDetail toEntity (HarvestDetailRequestDTO dto );
    HarvestDetailResponseDTO toResponseDto (HarvestDetail entity );
    void updateEntityFromDto(HarvestDetailRequestDTO dto, @MappingTarget HarvestDetail entity);
}
