package main.controller;

import main.component.TourValidator;
import main.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TourValidator tourValidator;

    @Autowired
    public HomeController(TourValidator tourValidator) {
        this.tourValidator = tourValidator;
    }
    private List<Tour> tours = new ArrayList<>();
    @RequestMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/addTour")
    public String getForm(Model model){
        model.addAttribute("tour", new Tour());
        return "form";
    }

    @PostMapping("/processTour")
    public String postTour(@ModelAttribute @Valid Tour tour, BindingResult bindingResult){
        tourValidator.validate(tour, bindingResult);

        if(bindingResult.hasErrors()){
            return "form";
        }
        tours.add(tour);
        return "redirect:showOffer";
    }

    @GetMapping("/showOffer")
    public String getTours(Model model){
        model.addAttribute("tours", tours);
        return "tours";
    }
}
