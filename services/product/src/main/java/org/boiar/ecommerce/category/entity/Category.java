package org.boiar.ecommerce.category.entity;

import jakarta.persistence.*;
import lombok.*;
import org.boiar.ecommerce.product.entity.Product;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productsList;
}
