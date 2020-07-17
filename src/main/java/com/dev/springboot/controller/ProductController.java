package com.dev.springboot.controller;

import com.dev.springboot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
@AllArgsConstructor
public class ProductController {
    private static final int NUMBER = 1000;
    private final ProductService productService;

    @GetMapping("/most-commented")
    public Page<String> getMostCommented(@PageableDefault(size = NUMBER) Pageable pageable) {
        return productService.getAll(pageable);
    }
}
