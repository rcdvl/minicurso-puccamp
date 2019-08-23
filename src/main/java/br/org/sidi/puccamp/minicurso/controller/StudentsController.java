package br.org.sidi.puccamp.minicurso.controller;

import br.org.sidi.puccamp.minicurso.entity.Student;
import br.org.sidi.puccamp.minicurso.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentRepository studentsRepository;

    @RequestMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("students/index");
        modelAndView.addObject(new Student());
        modelAndView.addObject("students", studentsRepository.findByOrderByFullNameAsc());
        return modelAndView;
    }

    @PostMapping
    public String add(Student student) {
        studentsRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("students/show");
        modelAndView.addObject("student", studentsRepository.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/{id}/addFriend")
    public String addFriend(@PathVariable("id") Long id, @RequestParam("fullName") String friendName) {
        Student user = studentsRepository.findById(id).get();
        Student friend = studentsRepository.findByFullName(friendName);
        user.getFriends().add(friend);
        studentsRepository.save(user);
        return "redirect:/students/" + id;

    }
}
