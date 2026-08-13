package com.portfolio.anshul_portforlio;

import com.portfolio.anshul_portforlio.Services.ContactServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ContactServiceImplementation adminimplementation;
        @GetMapping("/home")
        public String home(){
            return "admin/adminhome";
        }
        @GetMapping("/readAllContact")
         public String ReadContact(Model model){
            model.addAttribute("ContactData",adminimplementation.readAllContacts());

        return "admin/ReadAllContact";
    }

}

