package com.dev.springboot.repository;

import com.dev.springboot.model.Word;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class WordRepositoryImpl{
    @PersistenceContext
    private EntityManager entityManager;

    public List<Word> findWordByLimit(int limit) {
        return entityManager.createQuery(
                "select w.id, w.text " +
                        "from Word w group by w.text order by count (w.text) desc",
                Word.class).setMaxResults(limit).getResultList();
    }


    public void save(Word word) {
        entityManager.persist(word);
    }
}
