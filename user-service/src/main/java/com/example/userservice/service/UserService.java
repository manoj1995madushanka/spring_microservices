package com.example.userservice.service;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.value_object.Department;
import com.example.userservice.value_object.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveDepartment(User department) {
        log.info("inside saveDepartment method departmentService");
        return userRepository.save(department);
    }

    public User findDepartmentById(Long departmentId) {
        log.info("inside findDepartmentById method departmentService");
        return userRepository.findByUserId(departmentId);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        ResponseTemplate responseTemplate = new ResponseTemplate();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(),Department.class);

        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);
        return responseTemplate;
    }
}
