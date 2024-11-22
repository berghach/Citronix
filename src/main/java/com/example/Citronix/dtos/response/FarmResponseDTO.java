package com.example.Citronix.dtos.response;

import com.example.Citronix.dtos.response.summary.FieldSummaryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FarmResponseDTO {
    private UUID id;
    private String name;
    private String location;
    private Double area;
    private LocalDate creationDate;
    private List<FieldSummaryDTO> fields;
}
