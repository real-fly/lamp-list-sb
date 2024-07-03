package org.example.lamplistsb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "lists")
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type_id", nullable = false)
    private Integer typeId;

    @Column(name = "library_name", nullable = false)
    private String libraryName;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "expiration", nullable = false)
    private Instant expiration;

}