package com.project.gendervalidator.controller;

import com.project.gendervalidator.service.GenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/gender")
public class GenderController {

    private final GenderService genderService;

    @GetMapping("/tokens")
    public String getAllTokens(){
        return genderService.getAllTokens();
    }
}
