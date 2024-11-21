package com.example.Citronix.dtos.request;


import com.example.Citronix.entities.Field;
import lombok.*;

import java.time.LocalDate;

@Builder(builderClassName = "Builder")
public record TreeRequestDTO(LocalDate plantationDate, long age, Field field) {
}
