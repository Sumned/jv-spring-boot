package com.dev.springboot;

import com.dev.springboot.util.CsvFileReader;
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

    @BeforeEach
    void setUp() {
    }

    @Test
    void name() {
    }

    @Test
    public void checkFileReader() throws IOException {
        assertEquals(3, fileReader.readFile(PATH).size());
    }
}
