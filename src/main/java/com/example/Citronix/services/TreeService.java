package com.example.Citronix.services;

import com.example.Citronix.dtos.request.TreeRequestDTO;
import com.example.Citronix.dtos.response.TreeResponseDTO;
import com.example.Citronix.entities.Tree;
import com.example.Citronix.mapper.BaseMapper;
import com.example.Citronix.repositories.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TreeService implements Services<TreeRequestDTO, TreeResponseDTO>{
    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private BaseMapper<Tree, TreeRequestDTO, TreeResponseDTO> baseMapper;

    @Override
    public Optional<TreeResponseDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<TreeResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public boolean save(TreeRequestDTO entity) {
        return false;
    }

    @Override
    public boolean update(TreeRequestDTO entity) {
        return false;
    }

    @Override
    public boolean delete(TreeRequestDTO entity) {
        return false;
    }
}
