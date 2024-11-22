package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.HarvestRequestDTO;
import com.example.Citronix.dtos.response.HarvestResponseDTO;
import com.example.Citronix.entities.Harvest;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface HarvestMapper extends BaseMapper<Harvest, HarvestRequestDTO, HarvestResponseDTO>{
}
