package com.example.Citronix.dtos.response.summary;

import com.example.Citronix.enums.Season;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
public class HarvestSummaryDTO {
    private UUID id;
    private LocalDate date;
    private Season season;
    private Double totalQuantity;

}
