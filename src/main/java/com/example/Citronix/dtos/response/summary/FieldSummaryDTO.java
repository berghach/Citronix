package com.example.Citronix.dtos.response.summary;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class FieldSummaryDTO {
    private UUID id;
    private Double area;

}
