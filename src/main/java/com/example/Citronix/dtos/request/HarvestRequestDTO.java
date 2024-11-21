package com.example.Citronix.dtos.request;


import com.example.Citronix.entities.Sale;
import com.example.Citronix.enums.Season;
import lombok.*;

import java.time.LocalDate;

@Builder(builderClassName = "Builder")
public record HarvestRequestDTO(LocalDate date, Season season, Double totalQuantity, Sale sale) {
}
