package org.boiar.ecommerce.product.repository.impl;

import lombok.RequiredArgsConstructor;
import org.boiar.ecommerce.product.entity.Product;
import org.boiar.ecommerce.product.repository.ProductRepository;
import org.boiar.ecommerce.product.repository.jpa.ProductRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductRepositoryJpa jpa;
    @Override
    public Product create(Product product) {
        return jpa.save(product);
    }

    @Override
    public Product update(Product product) {
        return jpa.save(product);
    }

    @Override
    public List<Product> getAll() {
        return jpa.findAll();
    }

    @Override
    public Optional<Product> getById(Long productId) {
        return jpa.findById(productId);
    }

    @Override
    public void delete(Long productId) {
        jpa.deleteById(productId);
    }

    @Override
    public boolean existsById(Long productId) {
        return jpa.existsById(productId);
    }

    @Override
    public List<Product> findAllByIdInOrderById(List<Long> productsIds) {
        return jpa.findAllByIdInOrderById(productsIds);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return jpa.saveAll(products);
    }
}
