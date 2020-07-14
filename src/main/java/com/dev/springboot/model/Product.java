package com.dev.springboot.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    private String productId;

    @ManyToMany
    @JoinTable(
            name = "users_products",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> userList;
    private boolean isFood;
    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Review> reviews = new ArrayList<>();
}
