package org.boiar.ecommerce.product.request;

import jakarta.validation.constraints.*;



public record ProductPurchaseRequest(
        @NotNull(message = "Product is mandatory")
        Long productId,

        @Min(1)
        @Positive(message = "Quantity is mandatory")
        double quantity
) {
}