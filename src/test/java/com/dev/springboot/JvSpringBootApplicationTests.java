package com.dev.springboot;

import com.dev.springboot.util.CsvFileReader;
import java.util.List;
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
    public void checkFileReader() {
        List<String> ls = fileReader.readFile(PATH);
        ls.forEach(System.out::println);
        assertEquals(3, ls.size());

    }
}
