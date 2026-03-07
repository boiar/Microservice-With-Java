package org.boiar.customer.response;
import org.boiar.customer.entity.Address;

public record GetCustomerResponse (
        String Id,
        String firstName,
        String lastName,
        String email,
        Address address
){}
