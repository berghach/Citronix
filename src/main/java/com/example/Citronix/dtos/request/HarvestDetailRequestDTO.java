package com.example.Citronix.dtos.request;


import com.example.Citronix.entities.Harvest;
import com.example.Citronix.entities.Tree;
import lombok.*;

import java.time.LocalDate;

@Builder(builderClassName = "Builder")
public record HarvestDetailRequestDTO(LocalDate date, Harvest harvest, Tree tree, Double quantity) {
}
