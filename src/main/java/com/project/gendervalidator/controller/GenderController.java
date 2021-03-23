package com.project.gendervalidator.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/gender")
public class GenderController {

    @GetMapping("/tokens")
    public String getAllTokens(){
        return "testing";
    }
}
