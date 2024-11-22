package com.example.Citronix.dtos.response.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TreeSummaryDTO {
    private UUID id;
    private LocalDate plantationDate;
    private long age;

}
