package com.portfolio.anshul_portforlio.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxUploadSize(MaxUploadSizeExceededException e, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        logger.warn("Maximum upload size exceeded: {}", e.getMessage());
        redirectAttributes.addFlashAttribute("errorMessage", "File size exceeds the allowable limit (Max 5MB).");
        redirectAttributes.addFlashAttribute("errors", "File size exceeds the allowable limit (Max 5MB).");
        return getSafeRedirectUrl(request);
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception e, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        logger.error("Unhandled exception occurred on path {}: ", request.getRequestURI(), e);
        redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong: " + (e.getMessage() != null ? e.getMessage() : "Unexpected error"));
        redirectAttributes.addFlashAttribute("errors", "Something went wrong. Please try again.");
        return getSafeRedirectUrl(request);
    }

    private String getSafeRedirectUrl(HttpServletRequest request) {
        String referer = request.getHeader("referer");
        if (referer != null && !referer.trim().isEmpty() && !referer.equalsIgnoreCase("null")) {
            return "redirect:" + referer;
        }

        String uri = request.getRequestURI();
        if (uri != null && uri.startsWith("/admin")) {
            return "redirect:/admin/home";
        }
        return "redirect:/client/home";
    }
}
