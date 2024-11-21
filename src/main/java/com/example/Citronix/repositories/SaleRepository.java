package com.example.Citronix.repositories;

import com.example.Citronix.entities.Sale;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface SaleRepository extends Repository<Sale, UUID> {
}
