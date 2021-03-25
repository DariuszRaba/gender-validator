package com.project.gendervalidator.dao;

import com.project.gendervalidator.exception.ResourceException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Component
public class TxtTokenFilesDAO implements TokensDAO {

    @Override
    public String getMalesTokens() {
        try {
            String NAME_OF_MALE_TOKENS_FILE = "male-names.txt";
            return getAllTokensFromFile(NAME_OF_MALE_TOKENS_FILE);
        } catch (NullPointerException ex) {
            throw new ResourceException("Male");
        }
    }

    @Override
    public String getFemalesTokens() {
       try {
           String NAME_OF_FEMALE_TOKENS_FILE = "female-names.txt";
           return getAllTokensFromFile(NAME_OF_FEMALE_TOKENS_FILE);
        } catch (NullPointerException ex) {
            throw new ResourceException("Female");
        }
    }

    private String getAllTokensFromFile(String fileName) throws NullPointerException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(fileName);
        return new BufferedReader(
                new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

}
