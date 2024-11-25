package com.example.Citronix.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "sale")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "harvest_id", referencedColumnName = "id")
    private Harvest harvest;
}
