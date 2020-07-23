package com.dev.springboot.repository;

import com.dev.springboot.model.UserCsv;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCsvRepository extends JpaRepository<UserCsv, String> {

    @Query("select u.profileName from UserCsv u order by size(u.reviews) desc ")
    Page<String> getAll(Pageable pageable);
}
