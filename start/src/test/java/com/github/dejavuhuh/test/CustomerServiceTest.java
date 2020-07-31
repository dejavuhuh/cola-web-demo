package com.github.dejavuhuh.test;

import com.alibaba.cola.dto.Response;
import com.github.dejavuhuh.api.CustomerServiceI;
import com.github.dejavuhuh.common.BizCode;
import com.github.dejavuhuh.dto.CustomerAddCmd;
import com.github.dejavuhuh.dto.domainmodel.Customer;
import com.github.dejavuhuh.dto.domainmodel.ErrorCode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This is for integration test.
 *
 * Created by fulan.zjf on 2017/11/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerServiceI customerService;


    @Before
    public void setUp() {

    }

    @Test
    public void testCustomerAddSuccess(){
        //1.prepare
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        Customer customer = new Customer();
        customer.setCompanyName("NormalName");
        customerAddCmd.setCustomer(customer);

        //2.execute
        Response response = customerService.addCustomer(customerAddCmd);

        //3.assert
        Assert.assertTrue(response.isSuccess());
    }

    @Test(expected = BizException.class)
    public void testCustomerAddCompanyNameConflict(){
        //1.prepare
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        Customer customer = new Customer();
        customer.setCompanyName("ConflictCompanyName");
        customerAddCmd.setCustomer(customer);

        //2.execute
        Response response = customerService.addCustomer(customerAddCmd);

        //3.assert
        Assert.assertEquals(ErrorCode.B_CUSTOMER_companyNameConflict.getErrCode(), response.getErrCode());

    }
}
