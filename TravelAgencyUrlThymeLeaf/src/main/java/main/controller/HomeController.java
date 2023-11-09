package main.controller;

import main.model.Tour;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<Tour> tours = new ArrayList<>();
    @RequestMapping("/home")
    public String getHome(){
        return "index";
    }

    // add a method to show the form that we will add a new tour
    @GetMapping("/addTour")
    public String showForm(Model model){
        model.addAttribute("tour", new Tour());
        return "form";
    }

    // add a method which will take an object from the form page, and it will save that object
    @PostMapping("/processForm")
    public String showTourDate(@ModelAttribute Tour tour){
        tours.add(tour);
        return "redirect:showOffer";
    }

    // add a method that will present all the records
    @GetMapping("/showOffer")
    public String getTours(Model model){
        model.addAttribute("tours", tours);
        return "tours";
    }
}
