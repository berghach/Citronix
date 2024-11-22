package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.HarvestDetailRequestDTO;
import com.example.Citronix.dtos.response.HarvestDetailResponseDTO;
import com.example.Citronix.entities.HarvestDetail;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface HarvestDetailMapper extends BaseMapper<HarvestDetail, HarvestDetailRequestDTO, HarvestDetailResponseDTO> {
}
