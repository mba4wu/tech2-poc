package com.beta.wheelsup.controller;
import com.beta.wheelsup.bean.SalesPerson;
import com.beta.wheelsup.exception.CustomException;
import com.beta.wheelsup.service.SalesPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mburns on 1/19/16.
 *
 */
@RestController
public class SalesPersonController {

    @Autowired
    SalesPersonService service;

    @RequestMapping("/salesPerson/{id}")
    public SalesPerson salesPerson(@PathVariable Long id) {
        return service.getSalesPersonById(id);
    }

    @RequestMapping("/salesPerson/all")
    public List<SalesPerson> salesPersonAll() {
        return service.findAll();
    }

    @RequestMapping("/salesPerson/all/sorted")
    public List<SalesPerson> salesPersonAllSorted() {
        return service.findAllByFirstName();
    }

    @RequestMapping(value="/salesPerson/new", method = RequestMethod.POST)
    public void salesPersonNew(@RequestBody SalesPerson salesPerson) throws CustomException {
        service.createSalesPerson(salesPerson);
    }

}
