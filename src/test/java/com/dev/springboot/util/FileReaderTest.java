package com.dev.springboot.util;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    private static final String PATH = "src/test/resources/test.txt";

    @BeforeEach
    void setUp() {
    }

    @Test
    public void checkFileReader() {
        List<String> list = FileReader.fileReader(PATH);
        assertEquals(3, list.size());
    }
}
