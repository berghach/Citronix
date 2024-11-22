package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.FarmRequestDTO;
import com.example.Citronix.dtos.response.FarmResponseDTO;
import com.example.Citronix.entities.Farm;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface FarmMapper extends BaseMapper<Farm, FarmRequestDTO, FarmResponseDTO>{
}
