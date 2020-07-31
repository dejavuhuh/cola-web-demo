package com.github.dejavuhuh.domain.gateway;

import com.github.dejavuhuh.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
