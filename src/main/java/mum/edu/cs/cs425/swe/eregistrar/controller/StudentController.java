package mum.edu.cs.cs425.swe.eregistrar.controller;

import mum.edu.cs.cs425.swe.eregistrar.Service.StudentService;
import mum.edu.cs.cs425.swe.eregistrar.modell.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/sign")
    public String signUpGet(Model theModel){
        theModel.addAttribute("signUp", new Student());
        return "user/signUp";
    }
    @PostMapping("/sign")
    public String signUpPost(@ModelAttribute("signUp") Student theUser){

        return "redirect:/";
    }

    @Autowired
    private StudentService studser;

    @GetMapping("/save")
    public String saveGet(Model theModel){
        theModel.addAttribute("toSave",new Student());

        return "student/addStudent";
    }


    @GetMapping("/list")
    public String list(Model theModel){
        theModel.addAttribute("allStudent",studser.allStudent());
        return "student/listStudentTable";
    }
    @GetMapping("/edit")
    public String editGet(@RequestParam("carId") Long carId, Model theModel){

        theModel.addAttribute("toSave",studser.findById(carId));

        return "car/editCar";
    }
    @PostMapping("/edit")
    public String editPost(@ModelAttribute("toSave") Student theCar){
        theCar.setId(theCar.getId());

        studser.save(theCar);
        return "redirect:/student/list";
    }

}
