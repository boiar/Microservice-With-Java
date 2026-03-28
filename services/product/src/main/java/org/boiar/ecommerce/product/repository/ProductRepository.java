package org.boiar.ecommerce.product.repository;

import org.boiar.ecommerce.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product create(Product product);

    Product update(Product product);

    List<Product> getAll();

    Optional<Product> getById(Long productId);

    void delete(Long productId);

    boolean existsById(Long productId);

    List<Product> findAllByIdInOrderById(List<Long> ids);

    List<Product> saveAll(List<Product> products);
}
