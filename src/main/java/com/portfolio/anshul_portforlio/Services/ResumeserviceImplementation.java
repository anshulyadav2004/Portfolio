package com.portfolio.anshul_portforlio.Services;

import com.portfolio.anshul_portforlio.DTO.resumeDto;
import com.portfolio.anshul_portforlio.Entities.resumeEntity;
import com.portfolio.anshul_portforlio.Repository.ResumeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ResumeserviceImplementation implements resumeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResumeRepository repository;

    @Override
    public resumeEntity saveresume(resumeDto resumedto, MultipartFile multipartFile, String realpath) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            throw new IllegalArgumentException("Resume file is required.");
        }

        String originalFilename = multipartFile.getOriginalFilename();
        if (originalFilename == null || originalFilename.trim().isEmpty()) {
            originalFilename = "resume.pdf";
        }
        String cleanOriginalName = new File(originalFilename).getName();
        String filename = UUID.randomUUID() + "_" + LocalDateTime.now().toString().replace(":", "-") + "_" + cleanOriginalName;

        resumeEntity entity = modelMapper.map(resumedto, resumeEntity.class);
        entity.setResumeFilename(filename);

        File uploadDir = new File(realpath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        Path path = Paths.get(realpath, filename);
        File file = path.toFile();
        try {
            multipartFile.transferTo(file);
        } catch (Exception e) {
            throw new RuntimeException("Resume file could not be saved to disk: " + e.getMessage(), e);
        }

        return repository.save(entity);
    }

    @Override
    public Optional<resumeEntity> getLatestResume() {
        return repository.findTopByOrderByIdDesc();
    }

    @Override
    public Optional<resumeEntity> getResumeById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<resumeEntity> getAllResumes() {
        return repository.findAll();
    }
}
