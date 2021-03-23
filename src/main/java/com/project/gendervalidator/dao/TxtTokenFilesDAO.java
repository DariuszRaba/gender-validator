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
    private final Path femalePath = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
            .getResource("female-names.txt")).toURI());

    public TxtTokenFilesDAO() throws URISyntaxException {
    }

    @Override
    public String getMalesTokens() {
        try {
            return getAllTokensFromFile(malePath);
        } catch (IOException e) {
            e.printStackTrace();
            return "There was a problem with male tokens";
        }
    }

    @Override
    public String getFemalesTokens() {
        try {
            return getAllTokensFromFile(femalePath);
        } catch (IOException e) {
            e.printStackTrace();
            return "There was a problem with female tokens";
        }
    }

    public String getAllTokensFromFile(Path filePath) throws IOException {
        Stream<String> lines = Files.lines(filePath);
        String tokenNames = lines.collect(Collectors.joining("\n"));
        lines.close();
        return tokenNames;
    }

}
