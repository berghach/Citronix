package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.SaleRequestDTO;
import com.example.Citronix.dtos.response.SaleResponseDTO;
import com.example.Citronix.entities.Sale;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface SaleMapper extends BaseMapper<Sale, SaleRequestDTO, SaleResponseDTO>{
}
