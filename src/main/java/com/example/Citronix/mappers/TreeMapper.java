package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.TreeRequestDTO;
import com.example.Citronix.dtos.response.TreeResponseDTO;
import com.example.Citronix.entities.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TreeMapper {
    TreeMapper INSTANCE = Mappers.getMapper(TreeMapper.class);

    @Mapping(target = "id", ignore = true)
    Tree toEntity ( TreeRequestDTO dto );
    TreeResponseDTO toResponseDto ( Tree entity );
    void updateEntityFromDto(TreeRequestDTO dto, @MappingTarget Tree entity);
}
