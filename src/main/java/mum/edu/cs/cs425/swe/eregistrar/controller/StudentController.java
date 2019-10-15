package mum.edu.cs.cs425.swe.eregistrar.controller;

import mum.edu.cs.cs425.swe.eregistrar.Service.StudentService;
import mum.edu.cs.cs425.swe.eregistrar.modell.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/home")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/eregistrar/student/list"})
    public ModelAndView listStdent(@RequestParam(defaultValue = "0") int pageNo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudentsPaged(pageNo));
        modelAndView.addObject( "currentpageNo", pageNo);
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/eregistrar/student/new"})
    public String displayNewBookForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/new";
    }

    @PostMapping(value = {"/eregistrar/student/new"})
    public String addNewBook(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        System.out.println(student);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }


    @RequestMapping(value = {"/view-all"})
    public ModelAndView viewAll(@RequestParam(defaultValue = "0") int pageno) {

        ModelAndView modelAndView = new ModelAndView();
        Page<Student> students = studentService.getAllStudentsPaged(pageno);
        long numberOfStudents = students.getTotalElements();
        modelAndView.addObject("students", students);
        modelAndView.addObject("currPageNo", pageno);
        modelAndView.addObject("numberOfStudents", numberOfStudents);
        modelAndView.addObject("flashBack", "/home/view-all");
        modelAndView.setViewName("student-list");
        return modelAndView;
    }

    /* SEARCH*/
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String search, @RequestParam(defaultValue = "0") int pageno, Model model) {
        Page<Student> students = studentService.search(search, pageno);
        long numberOfStudents = students.getTotalElements();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.addObject("currPageNo", pageno);
        modelAndView.addObject("numberOfStudents", numberOfStudents);
        modelAndView.addObject("flashBack", "/home/search?search=" + search);
        modelAndView.setViewName("student-list");
        return modelAndView;
    }

    /*ADD NEW STUDENT*/
    @RequestMapping("/add-new-student")
    public String addStudent(Model model) {


        model.addAttribute("student", new Student());


        return "add-new-student";
    }

    @RequestMapping("/save")
    public String save(@Valid @ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors())
            return "add-new-student";
        studentService.saveStudent(student);
        return "redirect:view-all";
    }

    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "add-new-student";
    }

    /* DELETE A STUDENT FROM THE LIST*/
    @RequestMapping("/deleteStudent")
    public RedirectView delete(@RequestParam("studentId") Long id, Model model) {
        studentService.deleteStudent(id);

        return new RedirectView("view-all", true);
    }

    @GetMapping(value = {"/eregistrar/student/edit/{studentId}"})
    public String editBook(@PathVariable Long studstudentId, Model model) {
        Student student = studentService.getStudentById(studstudentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = {"/eregistrar/student/edit"})
    public String updateBook(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }

        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

}


