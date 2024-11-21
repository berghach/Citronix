package com.example.Citronix.repositories;

import com.example.Citronix.entities.Tree;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface TreeRepository extends Repository<Tree, UUID> {
}
