package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.SaleRequestDTO;
import com.example.Citronix.dtos.response.SaleResponseDTO;
import com.example.Citronix.entities.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SaleMapper {
    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    Sale toEntity ( SaleRequestDTO dto );
    //@Mapping(target = "id", source = "id")
    SaleResponseDTO toResponseDto ( Sale entity );
    void updateEntityFromDto(SaleRequestDTO dto, @MappingTarget Sale entity);
}
