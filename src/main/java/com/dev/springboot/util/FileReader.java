package com.dev.springboot.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import java.io.File;

public class FileReader {
    public static String getFile(String path) throws IOException {
        //path = "D:\\java\\Reviews.csv";
        File file = new File(path);
        try {
            LineIterator iterator = FileUtils.lineIterator(file, "UTF-8");
            StringBuilder stringBuilder = new StringBuilder();
            while (iterator.hasNext()) {
                stringBuilder.append(iterator.nextLine());
            }
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not founded" + e);
        }
    }
}
