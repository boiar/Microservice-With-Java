package org.boiar.ecommerce.customer.response;
import org.boiar.ecommerce.customer.entity.Address;

public record GetCustomerResponse (
        String Id,
        String firstName,
        String lastName,
        String email,
        Address address
){}
