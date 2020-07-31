package com.github.dejavuhuh.domain.gateway;

import com.github.dejavuhuh.domain.customer.Customer;
import com.github.dejavuhuh.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
