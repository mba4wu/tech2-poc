package com.beta.wheelsup.repository;

import com.beta.wheelsup.bean.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mburns on 1/19/16.
 */
public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long>{

   List<SalesPerson> findAllByOrderByFirstName();
   List<SalesPerson> findByIsActiveTrue();

}
