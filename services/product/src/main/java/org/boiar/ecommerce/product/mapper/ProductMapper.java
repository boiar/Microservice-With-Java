package org.boiar.ecommerce.product.mapper;

import org.boiar.ecommerce.category.entity.Category;
import org.boiar.ecommerce.product.entity.Product;
import org.boiar.ecommerce.product.request.CreateProductRequest;
import org.boiar.ecommerce.product.request.UpdateProductRequest;
import org.boiar.ecommerce.product.response.ProductPurchaseResponse;
import org.boiar.ecommerce.product.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(CreateProductRequest request){
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .availableQty(request.availableQty())
                .build();
    }

    public Product toEntity(UpdateProductRequest request){
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .availableQty(request.availableQty())
                .category(
                        Category.builder()
                                .id(request.categoryId())
                                .build()
                )
                .build();
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAvailableQty(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toproductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
