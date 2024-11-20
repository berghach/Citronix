package com.example.Citronix.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "harvest_detail")
@NoArgsConstructor
@Getter
@Setter
public class HarvestDetail {
    @EmbeddedId
    private HarvestDetailId id = new HarvestDetailId();

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
