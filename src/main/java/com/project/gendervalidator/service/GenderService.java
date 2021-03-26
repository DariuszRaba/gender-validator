package com.project.gendervalidator.service;

import com.project.gendervalidator.dao.TokensDAO;
import com.project.gendervalidator.exception.ProvidedDataException;
import com.project.gendervalidator.model.Gender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class GenderService {

    private final TokensDAO txtTokenFilesDAO;
    private final String FIRST_PART_OF_PERSON_TO_BE_CHECKED = "FIRST";
    private final String ALL_PERSONS_NAMES_TO_BE_CHECKED = "ALL";

    public List<String[]> getAllTokens() {
        return Arrays.asList(txtTokenFilesDAO.getMalesTokens().split("\n"), txtTokenFilesDAO.getFemalesTokens().split("\n"));
    }

    public Gender getPersonGender(String part, String person) {
        String[] femaleTokens = txtTokenFilesDAO.getFemalesTokens().toUpperCase().split("\n");
        String[] maleTokens = txtTokenFilesDAO.getMalesTokens().toUpperCase().split("\n");
        List<String> personNamesNoSpaces = getPersonNamesNoSpaces(person);

        switch (part.toUpperCase()) {
            case FIRST_PART_OF_PERSON_TO_BE_CHECKED:
                return checkFirstNameVariant(femaleTokens, maleTokens, personNamesNoSpaces.get(0));
            case ALL_PERSONS_NAMES_TO_BE_CHECKED:
                return checkAllNamesVariant(femaleTokens, maleTokens, personNamesNoSpaces);
        }
        throw new ProvidedDataException();
    }

    private Gender checkFirstNameVariant(String[] femaleTokens, String[] maleTokens, String name) {
        return Arrays.asList(femaleTokens).contains(name) ? Gender.FEMALE : Arrays.asList(maleTokens).contains(name) ?
                Gender.MALE : Gender.INCONCLUSIVE;

    }

    private Gender checkAllNamesVariant(String[] femaleTokens, String[] maleTokens, List<String> person) {
        int maleMatch = (int) person.stream().filter(name -> Arrays.asList(maleTokens).contains(name)).count();
        int femaleMatch = (int) person.stream().filter(name -> Arrays.asList(femaleTokens).contains(name)).count();
        return maleMatch - femaleMatch > 0 ? Gender.MALE : maleMatch - femaleMatch < 0 ? Gender.FEMALE : Gender.INCONCLUSIVE;
    }

    private List<String> getPersonNamesNoSpaces(String person) {
        return Arrays.stream(person.toUpperCase().split(" "))
                .filter(name -> !name.equals(""))
                .collect(Collectors.toList());
    }
}
