package com.portfolio.anshul_portforlio.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handelGeneralExecption(Exception e, RedirectAttributes redirectAttributes, HttpServletRequest request){
       String header = request.getHeader("referer");
        redirectAttributes.addFlashAttribute("errors","Something went Wrong ");
        System.out.println(header);
        return "redirect:"+header;
    }

}
