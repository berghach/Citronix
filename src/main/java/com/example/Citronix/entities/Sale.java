package com.example.Citronix.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "sale")
@NoArgsConstructor
@Getter
@Setter
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="id")
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "client_name", length = 30)
    private String clientName;

    @Column(name = "unit_price")
    private Double unitPrice;

    @OneToOne
    @JoinColumn(name = "harvest_id", referencedColumnName = "id")
    private Harvest harvest;
}
