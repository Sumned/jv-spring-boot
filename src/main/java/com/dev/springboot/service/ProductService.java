package com.dev.springboot.service;

import com.dev.springboot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product addProduct(Product product);

    Product getByProductId(String id);

    Page<String> getAll(Pageable pageable);
}
