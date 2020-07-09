package com.dev.springboot;

import com.dev.springboot.util.CsvFileReader;
import com.dev.springboot.util.CsvParser;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JvSpringBootApplicationTests {
    private static final String PATH = "src\\test\\resources\\test.txt";

    @Autowired
    private CsvFileReader fileReader;

    @Autowired
    private CsvParser parser;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void checkFileReader() {
        assertEquals(5, fileReader.readFile(PATH).size());
    }

    @Test
    public void checkParser() throws IOException {
        assertEquals(4, parser.parse(PATH).size());
    }
}
