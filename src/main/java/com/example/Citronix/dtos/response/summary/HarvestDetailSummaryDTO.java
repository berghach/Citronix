package com.example.Citronix.dtos.response.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class HarvestDetailSummaryDTO {
    private LocalDate date;
    private HarvestSummaryDTO harvest;
    private TreeSummaryDTO tree;
    private Double quantity;
}
