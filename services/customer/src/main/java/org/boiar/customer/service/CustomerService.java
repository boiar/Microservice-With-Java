package org.boiar.customer.service;

import lombok.RequiredArgsConstructor;
import org.boiar.customer.exception.CustomerNotFoundException;
import org.boiar.customer.mapper.CustomerMapper;
import org.boiar.customer.request.CreateCustomerRequest;
import org.boiar.customer.request.UpdateCustomerRequest;
import org.boiar.customer.response.GetCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepo;
    private final CustomerMapper mapper;
    public String createCustomer(CreateCustomerRequest request) {

        var customer = customerRepo.save(mapper.toEntity(request));
        return customer.getId();
    }

    public void updateCustomer(String customerId, UpdateCustomerRequest request) {

        var customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(
                    format("Cannot update customer:: No customer found with this ID:: %s", customerId)
                ));

        mapper.updateEntity(customer, request);
        customerRepo.save(customer);
    }


    public List<GetCustomerResponse> getAllCustomer() {
        return customerRepo.findAll()
                .stream()
                .map(mapper::toGetCustomerResponse)
                .collect(Collectors.toList());

    }

    public GetCustomerResponse getCustomer(String customerId) {
        var customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("No customer found with this ID:: %s", customerId)
                ));

        return mapper.toGetCustomerResponse(customer);
    }

    public Boolean existsCustomer(String customerId) {
        return customerRepo.findById(customerId).isPresent();
    }

    public void deleteCustomer(String customerId) {
        customerRepo.deleteById(customerId);
    }
}
