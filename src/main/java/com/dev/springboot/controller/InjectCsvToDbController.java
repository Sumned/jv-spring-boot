package com.dev.springboot.controller;

import com.dev.springboot.mapper.ParserMapper;
import com.dev.springboot.service.UserCsvService;
import com.dev.springboot.util.CsvParser;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/inject")
@RestController
@AllArgsConstructor
public class InjectCsvToDbController {
    private static final String PATH = "Test.txt";
    private final ParserMapper parserMapper;
    private final CsvParser parser;
    private final UserCsvService userService;

    @GetMapping
    public HttpStatus get(@RequestParam(defaultValue = PATH) String path) throws IOException {
        parser.parse(PATH).forEach(parserDto
                -> userService.addUser(parserMapper.parser(parserDto)));
        return HttpStatus.ACCEPTED;
    }
}
