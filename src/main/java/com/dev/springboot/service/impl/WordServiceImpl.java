package com.dev.springboot.service.impl;

import com.dev.springboot.model.Word;
import com.dev.springboot.repository.WordRepository;
import com.dev.springboot.service.WordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @Override
    public Page<Word> findWordByLimit(Pageable pageable) {
        return wordRepository.queryFirst1000(pageable);
    }

    @Override
    public void save(Word word) {
        wordRepository.save(word);

    }
}
