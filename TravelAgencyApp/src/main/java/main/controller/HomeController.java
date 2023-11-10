package main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
    @RequestMapping("/home")
    public String getHome(){
        return "home";
    }

    @GetMapping("/showForm")
    public String getForm(){
        return "form";
    }
}
