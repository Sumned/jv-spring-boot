package com.dev.springboot;

import com.dev.springboot.util.CsvFileReader;
import com.dev.springboot.util.CsvParser;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JvSpringBootApplicationTests {
    private static final String PATH = "test.txt";
    private static final String INVALID_FILE_PATH = "tests.txt";
    private static final int LENGTH = 1612;
    private static final int SIZE = 4;

    @Autowired
    private CsvFileReader fileReader;

    @Autowired
    private CsvParser parser;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void checkFileReader() {
        assertEquals(LENGTH, fileReader.readFile(PATH).length());
    }

    @Test
    public void checkParser() throws IOException {
        assertEquals(SIZE, parser.parse(PATH).size());
    }

    @Test
    public void csvFileReaderThrowsExceptionTest() {
        assertThrows(UndeclaredThrowableException.class,
                () -> fileReader.readFile(INVALID_FILE_PATH));
    }
}
