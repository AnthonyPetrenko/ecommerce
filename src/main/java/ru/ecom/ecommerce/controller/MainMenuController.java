package ru.ecom.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuController {
    @GetMapping()
    public String getMainMenu() {
        return "main_menu";
    }
}