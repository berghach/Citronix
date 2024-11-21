package com.example.Citronix.dtos.response.summary;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
public class TreeSummaryDTO {
    private UUID id;
    private LocalDate plantationDate;
    private long age;

}
