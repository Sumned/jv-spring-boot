package com.dev.springboot.util;

import com.dev.springboot.dto.ParserDto;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class CsvParser {
    private final CsvFileReader fileReader;
    private final List<ParserDto> parserDtoList = new ArrayList<>();

    public List<ParserDto> parse(String path) throws IOException {
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(new StringReader(fileReader.readFile(path)));
        for (CSVRecord record : records) {
            if (record.size() == CsvHeaders.values().length) {
                ParserDto dto = ParserDto.builder()
                        .productId(record.get(CsvHeaders.ProductId))
                        .userId(record.get(CsvHeaders.UserId))
                        .profileName(record.get(CsvHeaders.ProfileName))
                        .helpfulnessNumerator(Integer.parseInt(record
                                .get(CsvHeaders.HelpfulnessNumerator)))
                        .helpfulnessDenominator(Integer.parseInt(record
                                .get(CsvHeaders.HelpfulnessDenominator)))
                        .score(Integer.parseInt(record.get(CsvHeaders.Score)))
                        .time(Long.parseLong(record.get(CsvHeaders.Time)))
                        .summary(record.get(CsvHeaders.Summary))
                        .text(record.get(CsvHeaders.Text))
                        .build();
                log.info("string successfully parced" + dto.toString());
                parserDtoList.add(dto);
            }
        }
        return parserDtoList;
    }

    enum CsvHeaders {
        Id, ProductId, UserId,
        ProfileName, HelpfulnessNumerator,
        HelpfulnessDenominator, Score,
        Time, Summary, Text
    }
}
