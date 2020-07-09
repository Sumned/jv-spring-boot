package com.dev.springboot.util;

import java.util.List;

public interface CsvFileReader {

    List<String> readFile(String path);
}
