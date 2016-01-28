package com.beta.wheelsup.service;

import com.beta.wheelsup.bean.SalesPerson;
import com.beta.wheelsup.config.TestConfig;
import com.beta.wheelsup.exception.CustomException;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

/**
 * Created by mburns on 1/20/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class })
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
public class SalesPersonRepositoryTest {

    @Autowired
    public SalesPersonService service;


    @Test
    public void testGetSalesPersonById() {
        SalesPerson salesPerson =  service.getSalesPersonById(1882L);
        Assert.assertNotNull(salesPerson);
    }

    @Test
    public void testSaveSalesPerson() throws CustomException {
        SalesPerson salesPerson = TestUtils.createSalesPerson();
        service.createSalesPerson(salesPerson);
        Assert.assertNotNull(salesPerson);
    }

  @Test
    public void findAllByFirstNameSorted() {
      List<SalesPerson> salesPersons = service.findAllByFirstName();
      Assert.assertNotNull(service.findAllByFirstName());
    }

    @Test
    public void findAllActive() {
        List<SalesPerson> salesPersons = service.findAllActive();
        Assert.assertNotNull(service.findAllActive());
    }

}