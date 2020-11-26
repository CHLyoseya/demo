package com.hector.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hector.demo.service.UserService;

/**
 * @author hector.lin
 * @date 2020/8/10 15:16
 */
@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/list")
    public List<Map<String,Double>> list(){
        return null;
    }

}
