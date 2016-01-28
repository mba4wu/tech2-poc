package com.beta.wheelsup.service;

import com.beta.wheelsup.bean.SalesPerson;

import java.util.List;

/**
 * Created by mburns on 1/20/16.
 */
public class TestUtils {


    protected static SalesPerson createSalesPerson() {
        SalesPerson salesPerson = new SalesPerson();
        salesPerson.setFirstName("Marian");
        salesPerson.setLastName("Burns");
        salesPerson.setCompany("Wheels Up");
        return salesPerson;

    }

    protected static void printList(List<SalesPerson> salesPersons) {
        for (SalesPerson salesPerson : salesPersons) {
            System.out.println(salesPerson.getFirstName() + " " + salesPerson.getIsActive());

        }
    }
}
