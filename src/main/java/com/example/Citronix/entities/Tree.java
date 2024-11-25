package com.example.Citronix.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tree")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="id")
    private UUID id;

    @Column(name = "plantation_date")
    private LocalDate plantationDate;

    @Column(name = "age")
    private long age;

    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false, foreignKey = @ForeignKey(name = "fk_tree_field"))
    private Field field;

    @OneToMany(mappedBy = "tree", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HarvestDetail> harvestDetails;
}
