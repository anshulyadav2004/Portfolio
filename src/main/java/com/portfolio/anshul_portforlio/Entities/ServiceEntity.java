package com.portfolio.anshul_portforlio.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Service")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(length = 500)
    private String link;

    @Column(length = 1000)
    private String fileName;
}
