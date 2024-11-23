package com.example.Citronix.dtos.response;

import com.example.Citronix.dtos.response.summary.FarmSummaryDTO;
import com.example.Citronix.dtos.response.summary.TreeSummaryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldResponseDTO {
    private UUID id;
    private Double area;
    private FarmSummaryDTO farm;
    private List<TreeSummaryDTO> trees;
}
