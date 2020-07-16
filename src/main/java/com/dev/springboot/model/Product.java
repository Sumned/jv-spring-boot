package com.dev.springboot.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    private String productId;
    private boolean isFood;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(value = CascadeType.SAVE_UPDATE)
    private List<Review> reviews = new ArrayList<>();
}
