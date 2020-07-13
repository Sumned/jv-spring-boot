package com.dev.springboot.controller;

import com.dev.springboot.mapper.ParserMapper;
import com.dev.springboot.service.UserService;
import com.dev.springboot.util.CsvParser;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@AllArgsConstructor
public class InitController {
    private final ParserMapper parserMapper;
    private final CsvParser parser;
    private final UserService userService;
    private static final String PATH = "D:\\java\\jv-spring-boot\\src\\main\\resources\\test.txt";


    @GetMapping
    public void get() throws IOException {
        parser.parse(PATH).forEach(parserDto -> userService.addUser(parserMapper.parser(parserDto)));
    }
}
