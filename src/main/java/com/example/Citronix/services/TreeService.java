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
        Optional<Tree> optionalTree = treeRepository.findById(id);

        return optionalTree.map(tree -> baseMapper.toResponseDto(tree));
    }

    @Override
    public List<TreeResponseDTO> getAll() {
        List<Tree> trees = treeRepository.findAll();

        return trees.stream().map(tree -> baseMapper.toResponseDto(tree)).toList();
    }

    @Override
    public TreeResponseDTO save(TreeRequestDTO reqEntity) {
        Tree savedTree = treeRepository.save(baseMapper.toEntity(reqEntity));
        return baseMapper.toResponseDto(savedTree);
    }

    @Override
    public TreeResponseDTO update(TreeRequestDTO reqEntity, UUID oldId) {
        Optional<Tree> optionalExistingTree = treeRepository.findById(oldId);
        if(optionalExistingTree.isPresent()){
            Tree existingTree = optionalExistingTree.get();
            baseMapper.updateEntityFromDto(reqEntity, existingTree);
            Tree updatedTree = treeRepository.save(existingTree);
            return baseMapper.toResponseDto(updatedTree);
        }else {
            throw new RuntimeException("Entity not found for update");
        }
    }

    @Override
    public boolean delete(UUID oldId) {
        Optional<Tree> optionalTree = treeRepository.findById(oldId);
        if (optionalTree.isPresent()) {
            treeRepository.delete(optionalTree.get());
            return true;
        } else {
            return false;
        }
    }
}
