package com.project.gendervalidator.controller;

import com.project.gendervalidator.model.Gender;
import com.project.gendervalidator.service.GenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/gender")
public class GenderController {

    private final GenderService genderService;

    @GetMapping("/tokens")
    public List<String[]> getAllTokens() {
        return genderService.getAllTokens();
    }

    @GetMapping("/check/{part}/{person}")
    public Gender getGenderOfPerson(@PathVariable("part") String partToCheck, @PathVariable("person") String person) {
        return genderService.getPersonGender(partToCheck, person);
    }
}
