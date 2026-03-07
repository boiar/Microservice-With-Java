package org.boiar.customer.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.boiar.customer.entity.Address;

public record CreateCustomerRequest(

        @NotNull(message = "Customer first name is required")
        String firstName,

        @NotNull(message = "Customer last name is required")
        String lastName,

        @NotNull(message = "Customer email name is required")
        @Email(message = "Customer email is not a valid email address")
        String email,

        Address address
) {}
