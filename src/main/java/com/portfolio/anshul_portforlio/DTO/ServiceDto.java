package com.portfolio.anshul_portforlio.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ServiceDto {

    @Size(min = 2, max = 100, message = "Title should be between 2 and 100 characters")
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @Size(min = 2, max = 1000, message = "Description should be between 2 and 1000 characters")
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Project link cannot be blank")
    private String link;

    private MultipartFile serviceFile;
}


