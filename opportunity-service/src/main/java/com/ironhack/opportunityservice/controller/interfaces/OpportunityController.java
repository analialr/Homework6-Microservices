package com.ironhack.opportunityservice.controller.interfaces;

import com.ironhack.opportunityservice.models.Opportunity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

public interface OpportunityController {
    List<Opportunity> findAll();
    Opportunity findById(Long id);
    Opportunity create(Opportunity opportunity);
    void delete(Long id);

    // QUERIES BY PRODUCT //
    List<Object[] >  countOpportunitiesByProduct();
    List<Object[] > countOpportunitiesByProductAndStatusCLOSED_WON();
    List<Object[] > countOpportunitiesByProductAndStatusCLOSED_LOST();
    List<Object[] > countOpportunitiesByProductAndStatusOPEN();

    // QUANTITY STATES QUERIES //
    Double findMeanProductQuantity();
    Integer findMaxProductQuantity();
    Integer findMinProductQuantity();


//    //COUNT BY
//    List<Object[]> countOpportunitiesByProductAndSalesRepCLOSED_WON();
//    List<Object[]> countOpportunitiesByProductAndSalesRepCLOSED_LOST();
//    List<Object[]> countOpportunitiesByProductAndSalesRepOPEN();
//    List<Object[]> countOpportunityBySalesRep();
//

}
