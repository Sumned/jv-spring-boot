package com.dev.springboot.util;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Cleanup;
import org.springframework.stereotype.Component;

@Component
public class CsvFileReaderImpl implements CsvFileReader {

    public List<String> readFile(String path) {
        try {
            @Cleanup Stream<String> stringStream = Files.lines(Paths.get(path));
            return stringStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}
