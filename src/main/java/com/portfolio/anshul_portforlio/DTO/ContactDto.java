package com.portfolio.anshul_portforlio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class ContactDto {
    private String name;
    private String email;
    private String subject;
    private String message;
}
