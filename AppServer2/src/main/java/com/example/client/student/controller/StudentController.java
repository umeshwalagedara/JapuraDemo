package com.example.client.student.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


  @RestController
  @CrossOrigin
  @RequestMapping("/student")
  public class StudentController {

    @GetMapping("/{id}")
    public String getStudent(@PathVariable int id){
      return "student from student service studentId="+ id;
    }


  }
