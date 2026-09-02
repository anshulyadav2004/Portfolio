package com.portfolio.anshul_portforlio.Services;

import com.portfolio.anshul_portforlio.DTO.ServiceDto;
import com.portfolio.anshul_portforlio.Entities.ServiceEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ServiceSave {
    ServiceEntity saveService(String realpath, MultipartFile multipartFile, ServiceDto dto);
    List<ServiceEntity> readAllService();
    void deleteService(String realpath, int id, String fileName);
    Optional<ServiceEntity> readService(int id);
    ServiceEntity updateService(String realpath, int id, ServiceDto dto, String oldFileName);
}
