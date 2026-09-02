package com.portfolio.anshul_portforlio;

import com.portfolio.anshul_portforlio.DTO.ContactDto;
import com.portfolio.anshul_portforlio.Entities.resumeEntity;
import com.portfolio.anshul_portforlio.Services.ContactService;
import com.portfolio.anshul_portforlio.Services.ServiceSave;
import com.portfolio.anshul_portforlio.Services.resumeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/client")
public class MyController {

    @Autowired
    private ContactService implementation;

    @Autowired
    private ServiceSave serviceSaveImplementation;

    @Autowired
    private resumeService resumeService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("listofservices", serviceSaveImplementation.readAllService());
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("listofservices", serviceSaveImplementation.readAllService());
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/saveContact")
    public String saveContact(@Valid @ModelAttribute ContactDto dto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<FieldError> listOfError = bindingResult.getFieldErrors();
            model.addAttribute("error", listOfError);
            return "contact";
        }
        if (implementation.isContactEmailExist(dto.getEmail())) {
            redirectAttributes.addFlashAttribute("msg", "Email Already Exists");
            return "redirect:/client/contact";
        }
        implementation.saveContact(dto);
        redirectAttributes.addFlashAttribute("msg", "Contact Saved Successfully");
        return "redirect:/client/contact";
    }

    @GetMapping(value = {"/downloadResume", "/Download"})
    public ResponseEntity<Resource> downloadResume(HttpServletRequest request) {
        Optional<resumeEntity> latestResumeOpt = resumeService.getLatestResume();
        if (latestResumeOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        resumeEntity entity = latestResumeOpt.get();
        String filename = entity.getResumeFilename();
        if (filename == null || filename.trim().isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        String realpath = request.getServletContext().getRealPath("img/resumes/");
        if (realpath == null || realpath.trim().isEmpty()) {
            realpath = new File("src/main/webapp/img/resumes").getAbsolutePath() + File.separator;
        }

        File file = new File(realpath + File.separator + filename);
        if (!file.exists()) {
            File fallback = new File("src/main/webapp/img/resumes/" + filename);
            if (fallback.exists()) {
                file = fallback;
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        Resource resource = new FileSystemResource(file);
        String extension = filename.contains(".") ? filename.substring(filename.lastIndexOf(".")) : ".pdf";
        String downloadName = entity.getResumeTitle() != null && !entity.getResumeTitle().trim().isEmpty()
                ? entity.getResumeTitle().replaceAll("[^a-zA-Z0-9._-]", "_") + extension
                : "resume" + extension;

        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;
        if (filename.toLowerCase().endsWith(".pdf")) {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok()
                .contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + downloadName + "\"")
                .body(resource);
    }
}
