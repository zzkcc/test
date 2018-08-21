package com.taotao.controller;

import com.taotao.pojo.Student;
import com.taotao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @ResponseBody
    @RequestMapping(value = "/getByName/{name}",method = RequestMethod.GET)
    public Object getByName(@PathVariable String name){
        System.out.println(11111);
        Student st = studentService.getByName(name);
        return st;
    }

    @ResponseBody
    @RequestMapping(value="/init",method = RequestMethod.GET)
    public void initSb(){
        studentService.insertSb();
    }

    @ResponseBody
    @RequestMapping(value="/insertFromWeb/{name}/{mobile}")
    public void insertFromWeb(@PathVariable String name ,@PathVariable String mobile){
        Student student = new Student();
        student.setName(name);
        student.setMobile(mobile);

       studentService.insertFromWeb(student);
    }

    @ResponseBody
    @RequestMapping(value="/insertFromWeb1")
    public void insertFromWeb1(String name ,String mobile){
        Student student = new Student();
        student.setName(name);
        student.setMobile(mobile);

        studentService.insertFromWeb(student);
        System.out.println(student.getId() );
    }
}
