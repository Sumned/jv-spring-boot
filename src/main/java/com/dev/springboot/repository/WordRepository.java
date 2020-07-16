package com.dev.springboot.repository;

import com.dev.springboot.model.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    @Query("select w.text, count (w.text) as counter "
            + "from Word w group by w.text order by count (w.text) desc")
    Page<Word> getAll(Pageable pageable);
}
