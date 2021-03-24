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
    public void should_return_female_gender_checking_first_name() {
        //given
        String variant = "first";
        String person = "Helena Pazdziochowa";
        when(txtTokenFilesDAO.getFemalesTokens()).thenReturn(prepareFemaleTokensData());
        when(txtTokenFilesDAO.getMalesTokens()).thenReturn(prepareMaleTokensData());
        //when
        Gender personGender = genderService.getPersonGender(variant, person);
        //then
        assertEquals(personGender, Gender.FEMALE);
    }

    @Test
    public void should_return_male_gender_checking_first_name() {
        //given
        String variant = "first";
        String person = "Arnold Boczek";
        when(txtTokenFilesDAO.getFemalesTokens()).thenReturn(prepareFemaleTokensData());
        when(txtTokenFilesDAO.getMalesTokens()).thenReturn(prepareMaleTokensData());
        //when
        Gender personGender = genderService.getPersonGender(variant, person);
        //then
        assertEquals(personGender, Gender.MALE);
    }

    @Test
    public void should_return_inconclusive_gender_checking_first_name() {
        //given
        String variant = "first";
        String person = "Kiepski Boczek";
        when(txtTokenFilesDAO.getFemalesTokens()).thenReturn(prepareFemaleTokensData());
        when(txtTokenFilesDAO.getMalesTokens()).thenReturn(prepareMaleTokensData());
        //when
        Gender personGender = genderService.getPersonGender(variant, person);
        //then
        assertEquals(personGender, Gender.INCONCLUSIVE);
    }

    @Test
    public void should_return_female_gender_all_names_checking_variant() {
        //given
        String variant = "all";
        String person = "Marian Helena Mariola";
        when(txtTokenFilesDAO.getFemalesTokens()).thenReturn(prepareFemaleTokensData());
        when(txtTokenFilesDAO.getMalesTokens()).thenReturn(prepareMaleTokensData());
        //when
        Gender personGender = genderService.getPersonGender(variant, person);
        //then
        assertEquals(personGender, Gender.FEMALE);
    }

    @Test
    public void should_return_male_gender_all_names_checking_variant() {
        //given
        String variant = "all";
        String person = "Marian Helena Waldemar";
        when(txtTokenFilesDAO.getFemalesTokens()).thenReturn(prepareFemaleTokensData());
        when(txtTokenFilesDAO.getMalesTokens()).thenReturn(prepareMaleTokensData());
        //when
        Gender personGender = genderService.getPersonGender(variant, person);
        //then
        assertEquals(personGender, Gender.MALE);
    }

    @Test
    public void should_return_inconclusive_gender_all_names_checking_variant() {
        //given
        String variant = "all";
        String person = "Marian Helena Pazdziochy";
        when(txtTokenFilesDAO.getFemalesTokens()).thenReturn(prepareFemaleTokensData());
        when(txtTokenFilesDAO.getMalesTokens()).thenReturn(prepareMaleTokensData());
        //when
        Gender personGender = genderService.getPersonGender(variant, person);
        //then
        assertEquals(personGender, Gender.INCONCLUSIVE);
    }

    @Test
    public void should_be_letter_size_proof() {
        //given
        when(txtTokenFilesDAO.getFemalesTokens()).thenReturn(prepareFemaleTokensData());
        when(txtTokenFilesDAO.getMalesTokens()).thenReturn(prepareMaleTokensData());
        String variant = "fIrSt";
        String femaleNameCapitalized = "HELENA";
        String femaleNameLowerCase = "helena";
        String femaleNameMixed = "hElEnA";
        String maleNameCapitalized = "WALDEMAR";
        String maleNameLowerCase = "waldemar";
        String maleNameMixed = "WaLdEmAr";

        //then
        assertEquals(Gender.FEMALE, genderService.getPersonGender(variant, femaleNameCapitalized));
        assertEquals(Gender.FEMALE, genderService.getPersonGender(variant, femaleNameLowerCase));
        assertEquals(Gender.FEMALE, genderService.getPersonGender(variant, femaleNameMixed));
        assertEquals(Gender.MALE, genderService.getPersonGender(variant, maleNameCapitalized));
        assertEquals(Gender.MALE, genderService.getPersonGender(variant, maleNameLowerCase));
        assertEquals(Gender.MALE, genderService.getPersonGender(variant, maleNameMixed));
    }

    @Test
    public void should_be_too_much_space_between_names_proof() {
        //given
        String variant = "all";
        String person = "   Marian     Helena      Pazdziochy";
        when(txtTokenFilesDAO.getFemalesTokens()).thenReturn(prepareFemaleTokensData());
        when(txtTokenFilesDAO.getMalesTokens()).thenReturn(prepareMaleTokensData());
        //when
        Gender personGender = genderService.getPersonGender(variant, person);
        //then
        assertEquals(personGender, Gender.INCONCLUSIVE);
    }

    @Test
    public void should_return_all_tokens(){
        //given
        int numberOfTokens = 7;
        when(txtTokenFilesDAO.getFemalesTokens()).thenReturn(prepareFemaleTokensData());
        when(txtTokenFilesDAO.getMalesTokens()).thenReturn(prepareMaleTokensData());
        //when
        String[] allTokens = genderService.getAllTokens().split("\n");
        //then
        assertEquals(numberOfTokens,allTokens.length);
    }


    private String prepareMaleTokensData() {
        return "Ferdynand\nMarian\nArnold\nWaldemar\n";
    }

    private String prepareFemaleTokensData() {
        return "Halina\nMariola\nHelena\n";
    }
}
