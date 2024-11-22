package com.example.Citronix.dtos.response.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FieldSummaryDTO {
    private UUID id;
    private Double area;

}
