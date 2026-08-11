package com.portfolio.anshul_portforlio.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Contacts")
public class ContactEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String name;
    @Column(length = 50,unique = true)
    private String email;
    @Column(length = 10)
    private String subject;
    @Column(length = 1000)
    private String message;
    private String datetime;
}
