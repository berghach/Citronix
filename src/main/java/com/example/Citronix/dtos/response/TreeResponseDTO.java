package com.example.Citronix.dtos.response;

import com.example.Citronix.dtos.response.summary.FieldSummaryDTO;
import com.example.Citronix.dtos.response.summary.HarvestDetailSummaryDTO;
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
public class TreeResponseDTO {
    private UUID id;
    private LocalDate plantationDate;
    private long age;
    private FieldSummaryDTO field;
    private List<HarvestDetailSummaryDTO> harvestDetails;
}
