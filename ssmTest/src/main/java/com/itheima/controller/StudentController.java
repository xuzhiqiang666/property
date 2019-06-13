package com.itheima.controller;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/studentController")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = studentService.findAll();
        modelAndView.addObject("studentList", studentList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("/findOne")
    public ModelAndView findOne(int id){
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentService.findOne(id);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Student student){
        studentService.update(student);
        return "redirect:/studentController/findAll";
    }

    @RequestMapping("/save")
    public String save(Student student){
        studentService.save(student);
        return "redirect:/studentController/findAll";
    }

    @RequestMapping("/delete")
    public String delete(Integer[] ids){
        studentService.delete(ids);
        return "redirect:/studentController/findAll";
    }

}
