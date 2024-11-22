package com.example.Citronix.mappers;

import com.example.Citronix.dtos.request.TreeRequestDTO;
import com.example.Citronix.dtos.response.TreeResponseDTO;
import com.example.Citronix.entities.Tree;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface TreeMapper extends BaseMapper<Tree, TreeRequestDTO, TreeResponseDTO>{
}
