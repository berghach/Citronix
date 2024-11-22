package com.example.Citronix.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "farm")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Accessors(chain = true)
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
