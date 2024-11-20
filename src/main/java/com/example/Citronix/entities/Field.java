package com.example.Citronix.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "field")
@NoArgsConstructor
@Getter
@Setter
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="id")
    private UUID id;

    @Column(name = "area")
    private Double area;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false, foreignKey = @ForeignKey(name = "fk_field_farm"))
    private Farm farm;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<Tree> trees;
}
