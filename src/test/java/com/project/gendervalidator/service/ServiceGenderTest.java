package com.project.gendervalidator.service;

import com.project.gendervalidator.dao.TxtTokenFilesDAO;
import com.project.gendervalidator.model.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceGenderTest {

    @Mock
    private TxtTokenFilesDAO txtTokenFilesDAO;


    @InjectMocks
    private GenderService genderService;

   @Test
    public void should_return_female_gender(){
        //given
        String variant = "first";
        String person = "Helena Pazdziochowa";
        when(txtTokenFilesDAO.getFemalesTokens()).thenReturn(prepareFemaleTokensData());
        when(txtTokenFilesDAO.getMalesTokens()).thenReturn(prepareMaleTokensData());
        //when
        Gender personGender = genderService.getPersonGender(variant, person);
        //then
        assertEquals(personGender,Gender.FEMALE);
    }


    private String prepareMaleTokensData(){
        return "Ferdynant\nMarian\nArnold\nWaldemar";
    }

    private String prepareFemaleTokensData(){
        return "Halina\nMariola\nHelena";
    }
}
