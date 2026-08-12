package com.portfolio.anshul_portforlio.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class ContactDto {
    @Size(min = 2,max = 30,message = "Invalid Name:- It should be in range of 2-30")
    @NotBlank(message = "Can not be Blank")
    private String name;
    @Size(min =2,max=50,message = "Invalid Email Length")
    @NotBlank(message = "Can not be Blank")
    private String email;
    @Size(min =2,max=10,message = "Inavlid Email Length")
    @NotBlank(message = "Can not be Blank")
    private String subject;
    @Size(min=2,max=500,message = "Invalid Message")
    @NotBlank(message = "Can not be Blank")
    private String message;
}
