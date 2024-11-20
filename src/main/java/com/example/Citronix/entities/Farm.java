package com.example.Citronix.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "farm")
@NoArgsConstructor
@Getter @Setter
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="id")
    private UUID id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "location", length = 30)
    private String location;

    @Column(name = "area")
    private Double area;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    private List<Field> fields;
}
