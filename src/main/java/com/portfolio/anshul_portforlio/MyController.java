package com.portfolio.anshul_portforlio;

import com.portfolio.anshul_portforlio.DTO.ContactDto;
import com.portfolio.anshul_portforlio.Services.ContactServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String saveContact(@ModelAttribute ContactDto dto, RedirectAttributes redirectAttributes){
        implementation.saveContact(dto);
        redirectAttributes.addFlashAttribute("msg","Contact Saved");
        return"redirect:/client/contact";
    }

}
