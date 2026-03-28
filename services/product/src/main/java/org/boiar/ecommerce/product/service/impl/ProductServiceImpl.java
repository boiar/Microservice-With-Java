package org.boiar.ecommerce.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.boiar.ecommerce.product.exception.ProductPurchaseException;
import org.boiar.ecommerce.product.request.ProductPurchaseRequest;
import org.boiar.ecommerce.product.response.ProductPurchaseResponse;
import org.boiar.ecommerce.product.service.ProductService;
import org.boiar.ecommerce.product.entity.Product;
import org.boiar.ecommerce.product.exception.ProductNotFoundException;
import org.boiar.ecommerce.product.mapper.ProductMapper;
import org.boiar.ecommerce.product.repository.ProductRepository;
import org.boiar.ecommerce.product.request.CreateProductRequest;
import org.boiar.ecommerce.product.request.UpdateProductRequest;
import org.boiar.ecommerce.product.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final ProductMapper mapper;

    public ProductResponse create(CreateProductRequest request) {
        Product product = mapper.toEntity(request);
        Product saved = productRepo.create(product);
        return mapper.toResponse(saved);
    }

    @Override
    public ProductResponse update(UpdateProductRequest request, Long id) {
        Product product = mapper.toEntity(request);
        if (!productRepo.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        product.setId(id);
        Product updated = productRepo.update(product);
        return mapper.toResponse(updated);
    }

    @Override
    public List<ProductResponse> getAll() {
        return productRepo.getAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse getById(Long id) {
        return productRepo.getById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        productRepo.delete(id);
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        var storedProducts = productRepo.findAllByIdInOrderById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exists");
        }

        Map<Long, ProductPurchaseRequest> requestMap = request.stream()
                .collect(Collectors.toMap(ProductPurchaseRequest::productId, r -> r));

        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();

        for (Product product : storedProducts) {
            var productRequest = requestMap.get(product.getId());

            if (product.getAvailableQty() < productRequest.quantity()) {
                throw new ProductPurchaseException(
                        "Insufficient stock quantity for product with ID: " + productRequest.productId()
                );
            }

            product.setAvailableQty(product.getAvailableQty() - productRequest.quantity());
            purchasedProducts.add(mapper.toproductPurchaseResponse(product, productRequest.quantity()));
        }

        productRepo.saveAll(storedProducts);

        return purchasedProducts;
    }


}
