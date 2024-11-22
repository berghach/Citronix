package com.example.Citronix.services;

import com.example.Citronix.dtos.request.TreeRequestDTO;
import com.example.Citronix.dtos.response.TreeResponseDTO;
import com.example.Citronix.entities.Tree;
import com.example.Citronix.mappers.TreeMapper;
import com.example.Citronix.repositories.TreeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TreeService implements Services<TreeRequestDTO, TreeResponseDTO>{
    private final TreeRepository treeRepository;
    private final TreeMapper treeMapper;

    @Override
    public Optional<TreeResponseDTO> get(UUID id) {
        Optional<Tree> optionalTree = treeRepository.findById(id);

        return optionalTree.map(treeMapper::toResponseDto);
    }

    @Override
    public List<TreeResponseDTO> getAll() {
        List<Tree> trees = treeRepository.findAll();

        return trees.stream().map(treeMapper::toResponseDto).toList();
    }

    @Override
    public TreeResponseDTO save(TreeRequestDTO reqEntity) {
        Tree savedTree = treeRepository.save(treeMapper.toEntity(reqEntity));
        return treeMapper.toResponseDto(savedTree);
    }

    @Override
    public TreeResponseDTO update(TreeRequestDTO reqEntity, UUID oldId) {
        Optional<Tree> optionalExistingTree = treeRepository.findById(oldId);
        if(optionalExistingTree.isPresent()){
            Tree existingTree = optionalExistingTree.get();
            treeMapper.updateEntityFromDto(reqEntity, existingTree);
            Tree updatedTree = treeRepository.save(existingTree);
            return treeMapper.toResponseDto(updatedTree);
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
