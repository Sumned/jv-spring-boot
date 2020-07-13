package com.dev.springboot;

import com.dev.springboot.dto.ParserDto;
import com.dev.springboot.mapper.ParserMapper;
import com.dev.springboot.model.User;
import com.dev.springboot.util.CsvFileReader;
import com.dev.springboot.util.CsvParser;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
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

    @Autowired
    private ParserMapper parserMapper;

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

    @Test
    public void dtoTest() throws IOException {
        for(ParserDto parserDto : parser.parse(PATH)) {
            User user = parserMapper.parser(parserDto);
            assertAll(() -> assertNotNull(user),
                    () -> assertFalse(user.getProducts().isEmpty()),
                    () -> assertFalse(user.getReviews().isEmpty()));
        }
    }
}
