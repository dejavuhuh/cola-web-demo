package com.github.dejavuhuh.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.github.dejavuhuh.dto.CustomerAddCmd;
import com.github.dejavuhuh.dto.CustomerListByNameQry;
import com.github.dejavuhuh.dto.domainmodel.Customer;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<Customer> listByName(CustomerListByNameQry customerListByNameQry);
}
