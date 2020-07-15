package com.dev.springboot.service;

import com.dev.springboot.model.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WordService {

    Page<Word> getAll(Pageable pageable);

    void save(Word word);
}
