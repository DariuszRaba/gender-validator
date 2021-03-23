package com.project.gendervalidator.dao;

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

    private final Path malePath = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
            .getResource("male-names.txt")).toURI());

    public TxtTokenFilesDAO() throws URISyntaxException {
    }

    @Override
    public String getMalesTokens() {
        try {
            Stream<String> lines = Files.lines(malePath);
            String maleNames = lines.collect(Collectors.joining("\n"));
            lines.close();
            return maleNames;
        } catch (IOException e) {
            e.printStackTrace();
            return "There was a problem with male tokens";
        }
    }

    @Override
    public String getFemalesTokens() {
        return null;
    }
}
