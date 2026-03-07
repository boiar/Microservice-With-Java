package org.boiar.ecommerce.customer.service;

import org.boiar.ecommerce.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
