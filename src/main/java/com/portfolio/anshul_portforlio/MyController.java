package com.portfolio.anshul_portforlio;

import com.portfolio.anshul_portforlio.DTO.ContactDto;
import com.portfolio.anshul_portforlio.Services.ContactServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/client")
public class MyController {
    @Autowired
    private ContactServiceImplementation implementation;

    @GetMapping("/home")
    public String home(){
        return"index";
    }
    @GetMapping("/about")
    public String about(){
        return"about";
    }
    @GetMapping("/services")
    public String services(){
        return"services";
    }
    @GetMapping("/contact")
    public String contact(){
        return"contact";
    }

    @PostMapping("/saveContact")
    public String saveContact(@Valid @ModelAttribute ContactDto dto, BindingResult bindingResult, Model modal, RedirectAttributes redirectAttributes){
         //  List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
           //for(FieldError error:fieldErrorList){
             //  String defaultMessage = error.getDefaultMessage();
           //}
        if(bindingResult.hasErrors()){
            List<FieldError> ListOfError = bindingResult.getFieldErrors();
            System.out.println(ListOfError);
            modal.addAttribute("error",ListOfError);
            return "contact";
        }
        if(implementation.isContactEmailExist(dto.getEmail())){
            redirectAttributes.addFlashAttribute("msg","Email Already Exist");
            return "redirect:/client/contact";
        }
        implementation.saveContact(dto);
        redirectAttributes.addFlashAttribute("msg","Contact Saved");
        return"redirect:/client/contact";
    }

}
