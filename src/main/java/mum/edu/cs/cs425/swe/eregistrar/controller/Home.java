package mum.edu.cs.cs425.swe.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping(value = {"/eregistrar/home","/","/eregistrar"})
    public String home() {
        return "home/index";
    }
}



