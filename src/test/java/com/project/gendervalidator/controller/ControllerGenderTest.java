package com.project.gendervalidator.controller;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration

public class ControllerGenderTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;

    @BeforeEach
    private void setUp(){
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void should_returned_200_status_code_from_all_tokens() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/gender/tokens")).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void should_returned_200_status_code_from_gender_checking() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/gender/check/first/darius")).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void should_return_400_status_code_when_wrong_endpoint() throws Exception {
        int status = mvc.perform(MockMvcRequestBuilders.get("/gender/check/whatAmIdoing/banng")).andReturn().getResponse().getStatus();
        assertEquals(400, status);
    }


}

