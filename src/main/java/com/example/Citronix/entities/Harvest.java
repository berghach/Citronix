package com.example.Citronix.entities;

import com.example.Citronix.enums.Season;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "harvest")
@NoArgsConstructor
@Getter
@Setter
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="id")
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "season")
    private Season season;

    @Column(name = "total_quantity")
    private Double totalQuantity;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "harvest")
    private Sale sale;

    @OneToMany(mappedBy = "harvest", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HarvestDetail> trees;
}
