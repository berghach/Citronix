package com.example.Citronix.dtos.response;

import com.example.Citronix.dtos.response.summary.HarvestDetailSummaryDTO;
import com.example.Citronix.dtos.response.summary.SaleSummaryDTO;
import com.example.Citronix.enums.Season;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HarvestResponseDTO {
    private UUID id;
    private LocalDate date;
    private Season season;
    private Double totalQuantity;
    private SaleSummaryDTO sale;
}
