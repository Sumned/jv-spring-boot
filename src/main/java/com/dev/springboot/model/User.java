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
import org.hibernate.annotations.Cascade;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private String userId;

    private String profileName;

    @ManyToMany
    @JoinTable(
            name = "users_products",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products = new ArrayList<>();

    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Review> reviews = new ArrayList<>();
}
