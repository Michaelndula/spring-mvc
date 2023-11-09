package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UrlParamsController {

    @RequestMapping("/welcome")
    public String showParams(HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println("Parameter: " + name);
        return "index";
    }

    @RequestMapping("/welcome2")
    public String showParamVersion2(@RequestParam(defaultValue = "welcome") String myParam){
        System.out.println("Parameter: " + myParam);
        return "index";
    }
}
