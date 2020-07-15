package com.dev.springboot.controller;

import com.dev.springboot.model.Word;
import com.dev.springboot.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/words")
@RestController
@AllArgsConstructor
public class WordController {
    private final WordService wordService;

    @GetMapping
    public Page<Word> get(@PageableDefault(page = 0, size = 1000) Pageable pageable) {
        return wordService.getAll(pageable);
    }
}