package com.example.Citronix.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BaseMapper<ENTITY, REQUEST, RESPONSE> {
    ENTITY toEntity ( REQUEST dto );

    RESPONSE toResponseDto ( ENTITY entity );
}
