package com.dev.springboot.controller;

import com.dev.springboot.mapper.ParserMapper;
import com.dev.springboot.util.FileReader;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@AllArgsConstructor
public class InitController {
    private final ParserMapper parserMapper;

    @GetMapping
    public void get() {
        FileReader.fileReader("D:\\java\\Reviews.csv").forEach(parserMapper::parser);
    }
}
