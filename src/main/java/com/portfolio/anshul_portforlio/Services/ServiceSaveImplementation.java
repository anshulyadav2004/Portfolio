package com.portfolio.anshul_portforlio.Services;

import com.portfolio.anshul_portforlio.DTO.ServiceDto;
import com.portfolio.anshul_portforlio.Entities.ServiceEntity;
import com.portfolio.anshul_portforlio.Repository.ServiceRepository;
import jakarta.transaction.Transactional;
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
@Transactional(rollbackOn = Exception.class)
public class ServiceSaveImplementation implements ServiceSave {

    @Autowired
    private ServiceRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ServiceEntity saveService(String realpath, MultipartFile multipartFile, ServiceDto dto) {
        String originalFilename = multipartFile != null ? multipartFile.getOriginalFilename() : "";
        if (originalFilename == null || originalFilename.trim().isEmpty()) {
            originalFilename = "service.png";
        }
        String cleanOriginalName = new File(originalFilename).getName();
        String filename = UUID.randomUUID().toString() + "_" + LocalDateTime.now().toString().replace(":", "-") + "_" + cleanOriginalName;

        ServiceEntity entity = modelMapper.map(dto, ServiceEntity.class);
        entity.setFileName(filename);

        File uploadDir = new File(realpath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        if (multipartFile != null && !multipartFile.isEmpty()) {
            Path path = Paths.get(realpath, filename);
            File file = path.toFile();
            try {
                multipartFile.transferTo(file);
            } catch (Exception e) {
                throw new RuntimeException("Could not save service file: " + e.getMessage(), e);
            }
        }

        return repo.save(entity);
    }

    @Override
    public List<ServiceEntity> readAllService() {
        return repo.findAll();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteService(String realpath, int id, String fileName) {
        repo.deleteById(id);
        if (fileName != null && !fileName.trim().isEmpty()) {
            File file = new File(realpath + File.separator + fileName);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Override
    public Optional<ServiceEntity> readService(int id) {
        return repo.findById(id);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ServiceEntity updateService(String realpath, int id, ServiceDto dto, String oldFileName) {
        Optional<ServiceEntity> optionalEntity = repo.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new IllegalArgumentException("Service with id " + id + " not found");
        }

        ServiceEntity entity = optionalEntity.get();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setLink(dto.getLink());

        MultipartFile multipartFile = dto.getServiceFile();
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String cleanOriginalName = new File(multipartFile.getOriginalFilename() != null ? multipartFile.getOriginalFilename() : "service.png").getName();
            String newFilename = UUID.randomUUID().toString() + "_" + LocalDateTime.now().toString().replace(":", "-") + "_" + cleanOriginalName;

            File uploadDir = new File(realpath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            Path path = Paths.get(realpath, newFilename);
            try {
                multipartFile.transferTo(path.toFile());
                if (oldFileName != null && !oldFileName.trim().isEmpty()) {
                    File oldFile = new File(realpath + File.separator + oldFileName);
                    if (oldFile.exists()) {
                        oldFile.delete();
                    }
                }
                entity.setFileName(newFilename);
            } catch (Exception e) {
                throw new RuntimeException("Could not update service file: " + e.getMessage(), e);
            }
        }

        return repo.save(entity);
    }
}
