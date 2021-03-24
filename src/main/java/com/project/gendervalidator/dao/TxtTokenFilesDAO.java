package com.project.gendervalidator.dao;

import com.project.gendervalidator.exception.ResourceException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TxtTokenFilesDAO implements TokensDAO {


    @Override
    public String getMalesTokens() {
        try {
            Path malePath = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("male-names.txt")).toURI());
            return getAllTokensFromFile(malePath);
        } catch (IOException | URISyntaxException e) {
            throw new ResourceException("Male");
        }
    }

    @Override
    public String getFemalesTokens() {
        try {
            Path femalePath = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("female-names.txt")).toURI());
            return getAllTokensFromFile(femalePath);
        } catch (IOException | URISyntaxException e) {
            throw new ResourceException("Female");
        }
    }

    private String getAllTokensFromFile(Path filePath) throws IOException {
        Stream<String> lines = Files.lines(filePath);
        String tokenNames = lines.collect(Collectors.joining("\n"));
        lines.close();
        return tokenNames;
    }

}
