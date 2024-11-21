package com.example.Citronix.dtos.request;

import com.example.Citronix.entities.Farm;
import lombok.Builder;

@Builder(builderClassName = "Builder")
public record FieldRequestDTO(Double area, Farm farm) {
}
