package com.example.Citronix.dtos.response.summary;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
public class FarmSummaryDTO {
    private UUID id;
    private String name;
    private String location;
    private Double area;
    private LocalDate creationDate;

}
