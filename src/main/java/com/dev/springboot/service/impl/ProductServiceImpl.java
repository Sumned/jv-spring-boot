package com.dev.springboot.service.impl;

import com.dev.springboot.model.Product;
import com.dev.springboot.repository.ProductRepository;
import com.dev.springboot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getByProductId(String id) {
        return productRepository.getByProductId(id);
    }

    @Override
    public Page<String> getAll(Pageable pageable) {
        return productRepository.getAll(pageable);
    }

}
