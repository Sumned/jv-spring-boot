package com.dev.springboot.repository;

import com.dev.springboot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product getByProductId(String id);

    @Query("select p.productId from Product p where p.isFood = true order by size(p.reviews) desc ")
    Page<String> getAll(Pageable pageable);
}
