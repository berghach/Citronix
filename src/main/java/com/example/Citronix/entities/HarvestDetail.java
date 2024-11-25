package com.example.Citronix.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Entity
@Table(name = "harvest_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class HarvestDetail {
    @EmbeddedId
    private final HarvestDetailId id = new HarvestDetailId();

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @MapsId("harvestId")
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;

    @ManyToOne
    @MapsId("treeId")
    @JoinColumn(name = "tree_id")
    private Tree tree;

    @Column(name = "quantity")
    private Double quantity;
}
