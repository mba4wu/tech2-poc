package com.beta.wheelsup.service;

import com.beta.wheelsup.bean.SalesPerson;
import com.beta.wheelsup.exception.CustomException;
import com.beta.wheelsup.repository.SalesPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Class providing the following services for SalesPerson:
 *      findById(param Long id):
 *      findAll:
 *      findAllSortedByFirstName:
 *      findAllActive
 *      globalExceptionHanling example:
 */


@Service
public class SalesPersonService {

    @Autowired
    SalesPersonRepository repository;


    public SalesPerson getSalesPersonById(Long id) {
        return repository.findOne(id);
    }

    public List<SalesPerson> findAll() {
        return repository.findAll();
    }

    public List<SalesPerson> findAllByFirstName() {
        return repository.findAllByOrderByFirstName();
    }


    public List<SalesPerson> findAllActive() {
        return repository.findByIsActiveTrue();
    }

    public void createSalesPerson(SalesPerson salesPerson) throws CustomException {
        salesPerson = repository.save(salesPerson);
        if (salesPerson == null)
                throw new CustomException();
    }


}
