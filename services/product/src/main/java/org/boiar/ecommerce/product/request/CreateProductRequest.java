package org.boiar.ecommerce.product.request;

import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;


public record CreateProductRequest(
        @NotNull(message = "Product should not null")
        @Size(min = 3, max = 255) @NotEmpty(message = "Product should not empty")
        String name,

        @NotNull(message = "Product description should not null")
        @Size(min = 3, max = 255)
        @NotEmpty(message = "Product description should not empty")
        String description,

        @Min(1)
        @Positive(message = "Quantity is mandatory")
        double availableQty,

        @NotNull(message = "Price should not null")
        BigDecimal price,

        @NotNull(message = "Product category is required")
        Integer categoryId
) {
}