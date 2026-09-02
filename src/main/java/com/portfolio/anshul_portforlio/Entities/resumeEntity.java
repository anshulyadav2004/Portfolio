package com.portfolio.anshul_portforlio.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "resume")
public class resumeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String resumeTitle;

    @Column(length = 1000)
    private String resumeDescription;

    @Column(length = 255)
    private String resumeFilename;
}


