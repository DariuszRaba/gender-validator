package com.project.gendervalidator.controller;

import com.project.gendervalidator.dao.TxtTokenFilesDAO;
import com.project.gendervalidator.service.GenderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class ApplicationContextConfig {

    @Bean
    public TxtTokenFilesDAO txtTokenFilesDAO(){
        return new TxtTokenFilesDAO();
    }
    @Bean
    public GenderService genderService(){
        return new GenderService(txtTokenFilesDAO());
    }
    @Bean
    public GenderController genderController(){
        return new GenderController(genderService());
    }
}
