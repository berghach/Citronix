package com.example.Citronix.dtos.response;

import com.example.Citronix.dtos.response.summary.HarvestSummaryDTO;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
public class SaleResponseDTO {
    private UUID id;
    private LocalDate date;
    private String clientName;
    private Double unitPrice;
    private HarvestSummaryDTO harvest;
}
