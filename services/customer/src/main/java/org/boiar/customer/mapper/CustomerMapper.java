package org.boiar.customer.mapper;

import org.boiar.customer.request.UpdateCustomerRequest;
import org.boiar.customer.entity.Customer;
import org.boiar.customer.request.CreateCustomerRequest;
import org.boiar.customer.response.GetCustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toEntity(CreateCustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public void updateEntity(Customer customer, UpdateCustomerRequest request) {
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
    }

    public GetCustomerResponse toGetCustomerResponse(Customer customer) {

        return new GetCustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
