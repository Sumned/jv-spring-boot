package com.dev.springboot.service;

import com.dev.springboot.model.UserCsv;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserCsvService {
    UserCsv addUser(UserCsv user);

    Page<String> getAll(Pageable pageable);
}
