package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import com.example.userservice.value_object.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveDepartment(@RequestBody User department) {
        log.info("inside saveDepartment method departmentController");
        return userService.saveDepartment(department);
    }

    /*@GetMapping("/{id}")
    public User findDepartmentById(@PathVariable("id") Long userId) {
        log.info("inside saveDepartment method departmentController");
        return userService.findDepartmentById(userId);
    }*/

    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId) {
        return userService.getUserWithDepartment(userId);
    }
}
