package br.org.sidi.puccamp.minicurso.controller;

import br.org.sidi.puccamp.minicurso.entity.Student;
import br.org.sidi.puccamp.minicurso.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentRepository studentsRepository;

    @RequestMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("students/index");
        modelAndView.addObject("students", studentsRepository.findByOrderByFullNameAsc());
        return modelAndView;
    }
}
