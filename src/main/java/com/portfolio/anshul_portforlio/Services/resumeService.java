package com.portfolio.anshul_portforlio.Services;

import com.portfolio.anshul_portforlio.DTO.resumeDto;
import com.portfolio.anshul_portforlio.Entities.resumeEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface resumeService {
    resumeEntity saveresume(resumeDto resumedto, MultipartFile multipartFile, String realpath);
    Optional<resumeEntity> getLatestResume();
    Optional<resumeEntity> getResumeById(int id);
    List<resumeEntity> getAllResumes();
}
