package com.dev.springboot.util;

import com.dev.springboot.model.dto.ParserDto;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Slf4j
public class FileReader {
    public static List<ParserDto> fileReader(String path) {
        List<ParserDto> ls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), StandardCharsets.UTF_8))) {
            CSVParser fileParser = new CSVParser(reader,
                    CSVFormat.DEFAULT.withHeader("Id","ProductId",
                    "UserId","ProfileName","HelpfulnessNumerator",
                    "HelpfulnessDenominator","Score","Time","Summary","Text"));
            Iterable<CSVRecord> csvRecords = fileParser.getRecords();
            int i = 0;
            for (CSVRecord csvRecord : csvRecords) {
                if (i == 500000) {
                    break;
                }
                i++;
                log.info(String.valueOf(i));
                if (i > 1) {
                    log.info(csvRecord.get("UserId"));
                    ParserDto dto = new ParserDto();
                    dto.setUserId(csvRecord.get("UserId"));
                    dto.setProfileName(csvRecord.get("ProfileName"));
                    dto.setHelpfulnessNumerator(Integer.parseInt(csvRecord.get(
                            "HelpfulnessNumerator")));
                    dto.setHelpfulnessDenominator(Integer.parseInt(
                            csvRecord.get("HelpfulnessDenominator")));
                    dto.setScore(Integer.parseInt(csvRecord.get("Score")));
                    dto.setTime(Long.parseLong(csvRecord.get("Time")));
                    dto.setProductId(csvRecord.get("ProductId"));
                    dto.setSummary(csvRecord.get("Summary"));
                    dto.setText(csvRecord.get("Text"));
                    ls.add(dto);
                }
            }
        } catch (IOException e) {
            log.info("File not founded " + e);
        }
        return ls;
    }
}
