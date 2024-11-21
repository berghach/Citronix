package com.example.Citronix.dtos.request;


import lombok.Builder;

import java.time.LocalDate;


@Builder(builderClassName = "Builder")
public record FarmRequestDTO(String name, String location, Double area, LocalDate creationDate) {
}
