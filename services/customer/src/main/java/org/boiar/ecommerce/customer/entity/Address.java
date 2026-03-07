package org.boiar.ecommerce.customer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Validated
public class Address {
    @Id
    private String id;
    private String street;
    private String houseNumber;
    private String zipCode;
}
