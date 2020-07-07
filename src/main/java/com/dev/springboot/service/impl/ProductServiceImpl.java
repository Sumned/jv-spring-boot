package com.dev.springboot.service.impl;

import com.dev.springboot.model.Product;
import com.dev.springboot.repository.ProductRepository;
import com.dev.springboot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
