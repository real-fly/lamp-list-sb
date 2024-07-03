package org.example.lamplistsb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "list_content")
public class ListContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "info_id", nullable = false)
    private Integer infoId;

    @Column(name = "value", nullable = false)
    private String value;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "expiration", nullable = false)
    private Instant expiration;

    @Column(name = "modifiedTime")
    private Instant modifiedTime;

}