package org.boiar.ecommerce.product.response;

import java.math.BigDecimal;

public record ProductResponse (
    Long id,
    String name,
    String description,
    BigDecimal price,
    Double quantity,
    Integer categoryId,
    String categoryName,
    String categoryDescription
){
}
