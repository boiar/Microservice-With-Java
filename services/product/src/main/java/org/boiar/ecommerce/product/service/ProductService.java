package org.boiar.ecommerce.product.service;

import org.boiar.ecommerce.product.entity.Product;
import org.boiar.ecommerce.product.request.CreateProductRequest;
import org.boiar.ecommerce.product.request.ProductPurchaseRequest;
import org.boiar.ecommerce.product.request.UpdateProductRequest;
import org.boiar.ecommerce.product.response.ProductPurchaseResponse;
import org.boiar.ecommerce.product.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse create(CreateProductRequest request);

    ProductResponse update(UpdateProductRequest request, Long id);

    List<ProductResponse> getAll();

    ProductResponse getById(Long id);

    void delete(Long id);

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);

}
