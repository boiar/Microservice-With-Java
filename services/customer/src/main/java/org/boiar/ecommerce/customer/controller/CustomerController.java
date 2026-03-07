package org.boiar.ecommerce.customer.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.boiar.ecommerce.customer.request.UpdateCustomerRequest;
import org.boiar.ecommerce.customer.response.GetCustomerResponse;
import org.boiar.ecommerce.customer.request.CreateCustomerRequest;
import org.boiar.ecommerce.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<String> createCustomer(
            @RequestBody
            @Valid
            CreateCustomerRequest request
    ){
        String msg = customerService.createCustomer(request);
        return ResponseEntity.ok("created");
    }

    @PutMapping("{customer-id}")
    public ResponseEntity<String> updateCustomer(
            @PathVariable("customer-id")
            String customerId,
            @RequestBody
            @Valid
            UpdateCustomerRequest request

    ){
        customerService.updateCustomer(customerId, request);
        return ResponseEntity.ok("updated!");
    }


    @GetMapping("")
    public ResponseEntity<List<GetCustomerResponse>> getAllCustomer(){
        return ResponseEntity.ok( customerService.getAllCustomer());
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<GetCustomerResponse> getCustomer(
            @PathVariable("customer-id")
            String customerId
    ){
        return ResponseEntity.ok( customerService.getCustomer(customerId));
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("customer-id")
            String customerId
    ){
        return ResponseEntity.ok( customerService.existsCustomer(customerId));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Valid> delete(
            @PathVariable("customer-id")
            String customerId
    ){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }


}

