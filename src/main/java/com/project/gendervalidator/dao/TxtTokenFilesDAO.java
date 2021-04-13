package com.project.gendervalidator.dao;

import com.project.gendervalidator.exception.ResourceException;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Component
public class TxtTokenFilesDAO implements TokensDAO {

    @Override
    public String getMalesTokens() {
        try {
            String NAME_OF_MALE_TOKENS_FILE = "male-names.txt";
            return getAllTokensFromFile(NAME_OF_MALE_TOKENS_FILE);
        } catch (IOException ex) {
            throw new ResourceException("Male");
        }
    }

    @Override
    public String getFemalesTokens() {
        try {
            String NAME_OF_FEMALE_TOKENS_FILE = "female-names.txt";
            return getAllTokensFromFile(NAME_OF_FEMALE_TOKENS_FILE);
        } catch (IOException ex) {
            throw new ResourceException("Female");
        }
    }

    private String getAllTokensFromFile(String fileName) throws IOException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (resourceAsStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8))) {

                return bufferedReader
                        .lines()
                        .collect(Collectors.joining("\n"));

            }
        }
        throw new IOException();
    }


}
