package com.portfolio.anshul_portforlio;

import com.portfolio.anshul_portforlio.DTO.ServiceDto;
import com.portfolio.anshul_portforlio.DTO.resumeDto;
import com.portfolio.anshul_portforlio.Entities.ServiceEntity;
import com.portfolio.anshul_portforlio.Services.ContactService;
import com.portfolio.anshul_portforlio.Services.ServiceSave;
import com.portfolio.anshul_portforlio.Services.resumeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ContactService adminimplementation;

    @Autowired
    private ServiceSave serviceSaveImplementation;

    @Autowired
    private resumeService resumeserviceImplementation;

    private String getUploadPath(HttpServletRequest request, String subfolder) {
        String realpath = request.getServletContext().getRealPath(subfolder);
        if (realpath == null || realpath.trim().isEmpty()) {
            realpath = new File("src/main/webapp/" + subfolder).getAbsolutePath() + File.separator;
        }
        File dir = new File(realpath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return realpath;
    }

    @GetMapping("/home")
    public String home() {
        return "admin/adminhome";
    }

    @GetMapping("/upload")
    public String upload(Model model) {
        if (!model.containsAttribute("resumeDto")) {
            model.addAttribute("resumeDto", new resumeDto());
        }
        return "admin/upload";
    }

    @PostMapping("/upload")
    public String uploadresume(@Valid @ModelAttribute("resumeDto") resumeDto dto, BindingResult bindingResult, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "admin/upload";
        }

        if (dto.getResumeFile() == null || dto.getResumeFile().isEmpty()) {
            model.addAttribute("errorMessage", "Please select a resume file to upload.");
            return "admin/upload";
        }

        String realpath = getUploadPath(request, "img/resumes/");
        MultipartFile multipartFile = dto.getResumeFile();
        resumeserviceImplementation.saveresume(dto, multipartFile, realpath);

        model.addAttribute("message", "Resume uploaded successfully.");
        model.addAttribute("resumeDto", new resumeDto());
        return "admin/upload";
    }

    @GetMapping("/readAllContact")
    public String ReadContact(Model model) {
        model.addAttribute("ContactData", adminimplementation.readAllContacts());
        return "admin/ReadAllContact";
    }

    @PostMapping("/deleteContact")
    public String DeleteContact(@RequestParam int id, RedirectAttributes redirectAttributes) {
        if (adminimplementation.deleteById(id)) {
            redirectAttributes.addFlashAttribute("deleted", "Contact deleted successfully");
        }
        return "redirect:/admin/readAllContact";
    }

    @GetMapping(value = {"/addService", "/adminService"})
    public String adminService(Model model) {
        if (!model.containsAttribute("serviceDto")) {
            model.addAttribute("serviceDto", new ServiceDto());
        }
        return "admin/adminService";
    }

    @PostMapping(value = {"/addService", "/adminService"})
    public String addservice(@Valid @ModelAttribute("serviceDto") ServiceDto dto, BindingResult result, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (result.hasErrors()) {
            model.addAttribute("error", result.getFieldErrors());
            model.addAttribute("result", "Invalid Input");
            return "admin/adminService";
        }
        if (dto.getServiceFile() == null || dto.getServiceFile().isEmpty()) {
            model.addAttribute("result", "File must be uploaded");
            return "admin/adminService";
        }
        MultipartFile multipartFile = dto.getServiceFile();

        long size = multipartFile.getSize();
        if (size > 5 * 1024 * 1024) {
            model.addAttribute("FileError", "File size should be less than 5MB");
            return "admin/adminService";
        }
        String realpath = getUploadPath(request, "img/services/");

        serviceSaveImplementation.saveService(realpath, multipartFile, dto);
        redirectAttributes.addFlashAttribute("result", "Service Added Successfully");

        return "redirect:/admin/addService";
    }

    @GetMapping("/readAllService")
    public String readAllServices(Model model) {
        model.addAttribute("listofservices", serviceSaveImplementation.readAllService());
        return "admin/readAllService";
    }

    @GetMapping("/deleteService")
    public String deletedService(@RequestParam int id, @RequestParam(required = false) String fileName, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String realpath = getUploadPath(request, "img/services/");
        serviceSaveImplementation.deleteService(realpath, id, fileName);
        redirectAttributes.addFlashAttribute("result", "Service Deleted Successfully");
        return "redirect:/admin/readAllService";
    }

    @GetMapping("/updateService")
    public String UpdateServiceView(@RequestParam int id, Model model) {
        Optional<ServiceEntity> entity = serviceSaveImplementation.readService(id);
        if (entity.isPresent()) {
            ServiceEntity serviceEntity = entity.get();
            model.addAttribute("servicedata", serviceEntity);
            ServiceDto dto = new ServiceDto();
            dto.setTitle(serviceEntity.getTitle());
            dto.setDescription(serviceEntity.getDescription());
            dto.setLink(serviceEntity.getLink());
            model.addAttribute("serviceDto", dto);
            return "admin/Update";
        }
        return "redirect:/admin/readAllService";
    }

    @PostMapping("/updateService")
    public String UpdateService(@RequestParam int id, @RequestParam(required = false) String OldfileName, @Valid @ModelAttribute("serviceDto") ServiceDto dto, BindingResult result, HttpServletRequest request, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            Optional<ServiceEntity> entity = serviceSaveImplementation.readService(id);
            entity.ifPresent(serviceEntity -> model.addAttribute("servicedata", serviceEntity));
            return "admin/Update";
        }

        String realpath = getUploadPath(request, "img/services/");
        serviceSaveImplementation.updateService(realpath, id, dto, OldfileName);
        redirectAttributes.addFlashAttribute("result", "Service Updated Successfully");
        return "redirect:/admin/readAllService";
    }
}

