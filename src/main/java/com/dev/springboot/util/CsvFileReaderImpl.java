package com.dev.springboot.util;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Cleanup;
import org.springframework.stereotype.Component;

@Component
public class CsvFileReaderImpl implements CsvFileReader {

    public String readFile(String path) {
        try {
            URI resource = Objects
                    .requireNonNull(CsvFileReaderImpl.class
                            .getClassLoader().getResource(path)).toURI();
            @Cleanup Stream<String> stringStream = Files.lines(Paths.get(resource));
            return stringStream.map(s -> s + "\n").collect(Collectors.joining());
        } catch (IOException | URISyntaxException | NullPointerException e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}
