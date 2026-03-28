package org.boiar.ecommerce.product.repository.jpa;

import org.boiar.ecommerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepositoryJpa extends JpaRepository<Product, Long> {

    List<Product> findAllByIdInOrderById(List<Long> ids);
}
