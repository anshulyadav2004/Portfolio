package com.portfolio.anshul_portforlio.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class resumeDto {

    @Size(min = 2, max = 100, message = "Title should be between 2 and 100 characters")
    @NotBlank(message = "Title cannot be blank")
    private String resumeTitle;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String resumeDescription;

    private MultipartFile resumeFile;
}
