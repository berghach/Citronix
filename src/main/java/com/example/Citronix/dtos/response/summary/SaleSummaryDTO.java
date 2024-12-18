package com.example.Citronix.dtos.response.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SaleSummaryDTO {
    private UUID id;
    private LocalDate date;
    private String clientName;
    private Double unitPrice;

}
