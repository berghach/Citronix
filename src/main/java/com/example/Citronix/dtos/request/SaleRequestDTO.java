package com.example.Citronix.dtos.request;

import com.example.Citronix.entities.Harvest;
import lombok.*;

import java.time.LocalDate;

@Builder(builderClassName = "Builder")
public record SaleRequestDTO(LocalDate date, String clientName, Double unitPrice, Harvest harvest) {
}
