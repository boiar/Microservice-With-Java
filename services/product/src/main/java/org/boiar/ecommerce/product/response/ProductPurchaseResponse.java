package org.boiar.ecommerce.product.response;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
    Long id,
    String name,
    String description,
    BigDecimal price,
    Double quantity
){
}
