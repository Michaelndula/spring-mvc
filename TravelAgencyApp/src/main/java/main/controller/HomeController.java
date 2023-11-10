package main.controller;

import main.model.Tour;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
    @RequestMapping("/home")
    public String getHome(){
        return "home";
    }

    @GetMapping("/addTour")
    public String getForm(Model model){
        model.addAttribute("tour", new Tour());
        return "form";
    }
}
