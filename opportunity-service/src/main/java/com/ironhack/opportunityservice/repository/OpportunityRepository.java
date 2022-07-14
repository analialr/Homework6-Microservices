package com.ironhack.opportunityservice.repository;

import com.ironhack.opportunityservice.models.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    Optional<Opportunity> findById(Long id);


    //---------------- BY PRODUCT ----------------//

    //    A count of all Opportunities by the product can be displayed by typing “Report Opportunity by the product”
    @Query(value = "SELECT o.product, count(o) FROM Opportunity o GROUP BY o.product")
    List<Object[] > countOpportunitiesByProduct();
    // SELECT o.product, count(*) FROM opportunity o GROUP BY o.product

    //    A count of all CLOSED_WON Opportunities by the product can be displayed by typing “Report CLOSED-WON by the product”
    @Query(value = "SELECT o.product, count(o) FROM Opportunity o WHERE o.status= 'CLOSED_WON' GROUP BY o.product")
    List<Object[] > countOpportunitiesByProductAndStatusCLOSED_WON();
    //SELECT o.product, count(*) FROM Opportunity o WHERE o.status='CLOSED_WON' GROUP BY o.product;


    //    A count of all CLOSED_LOST Opportunities by the product can be displayed by typing “Report CLOSED-LOST by the product”
    @Query(value = "SELECT o.product, count(o) FROM Opportunity o WHERE o.status='CLOSED_LOST' GROUP BY o.product")
    List<Object[] > countOpportunitiesByProductAndStatusCLOSED_LOST();


    //    A count of all OPEN Opportunities by the product can be displayed by typing “Report OPEN by the product”
    @Query(value = "SELECT o.product, count(o) FROM Opportunity o WHERE o.status='OPEN' GROUP BY o.product")
    List<Object[] > countOpportunitiesByProductAndStatusOPEN();

    //---------------- QUANTITY STATES ----------------//
    //SELECT AVG(quantity) FROM opportunity;
    @Query("SELECT AVG(quantity) FROM Opportunity")
    Optional<Double> findMeanProductQuantity();

    //SELECT MAX(quantity) FROM opportunity;
    @Query("SELECT MAX(quantity) FROM Opportunity")
    Optional<Integer> findMaxProductQuantity();

    //SELECT MIN(quantity) FROM opportunity;
    @Query("SELECT MIN(quantity) FROM Opportunity")
    Optional<Integer> findMinProductQuantity();




    // Estos 4 de aqui abajo no necesitan query raro


    //SELECT o.id, count(*) FROM opportunity o WHERE o.status='CLOSED_WON' GROUP BY o.id;
    @Query(value = "SELECT o.id, count(o) FROM Opportunity o WHERE o.status= 'CLOSED_WON' GROUP BY o.id")
    List<Object[] > countOpportunitiesByProductAndSalesRepCLOSED_WON();

    //SELECT o.id, count(*) FROM opportunity o WHERE o.status='CLOSED_LOST' GROUP BY o.id;
    @Query(value = "SELECT o.id, count(o) FROM Opportunity o WHERE o.status= 'CLOSED_LOST' GROUP BY o.id")
    List<Object[] > countOpportunitiesByProductAndSalesRepCLOSED_LOST();

    //SELECT o.id, count(*) FROM opportunity o WHERE o.status='OPEN' GROUP BY o.id;
    @Query(value = "SELECT o.id, count(o) FROM Opportunity o WHERE o.status= 'OPEN' GROUP BY o.id")
    List<Object[] > countOpportunitiesByProductAndSalesRepOPEN();

    //---------------- BY SALESREP ----------------//


    //SELECT o.id, count(*) FROM opportunity o JOIN sales_rep s ON o.sales_rep_id = s.id GROUP BY o.id;
    @Query (value = "SELECT o.salesRep, count(o) FROM Opportunity o GROUP BY o.salesRep")
    List<Object[] > countOpportunityBySalesRep();




    /*

    //---------------- BY COUNTRY ----------------//
    @Query(

    @Query("SELECT a.country, count(o) FROM Account a JOIN a.opportunityList o GROUP BY a.country")
    List<Object[]> countOppsByCountry();

    @Query("SELECT a.country, count(o) FROM Account a JOIN a.opportunityList o WHERE o.status ='CLOSED_WON' GROUP BY a.country")
    List<Object[]> countOppsByClosedWonStatusAndCountry(@Param("status") Status status);

    @Query("SELECT a.country, count(o) FROM Account a JOIN a.opportunityList o WHERE o.status = 'CLOSED_LOST' GROUP BY a.country")
    List<Object[]> countOppsByClosedLostAndCountry(@Param("status") Status status);


    @Query("SELECT  a.country, count(o) FROM Account a JOIN a.opportunityList o WHERE o.status = 'OPEN' GROUP BY a.country")
    List<Object[]> countOppsByOpenAndCountry(@Param("status") Status status);


    //---------------- BY CITY ----------------//
    @Query("SELECT a.city, count(o) FROM Account a JOIN a.opportunityList o GROUP BY a.city")
    List<Object[]> countOppsByCity();

    @Query("SELECT a.city, count(o) FROM Account a JOIN a.opportunityList o WHERE o.status = 'CLOSED_WON' GROUP BY a.city")
    List<Object[]> countOppsByClosedWonAndCity(@Param("status") Status status);

    @Query("SELECT a.city, count(o) FROM Account a JOIN a.opportunityList o WHERE o.status = 'CLOSED_LOST' GROUP BY a.city")
    List<Object[]> countOppsByClosedLostAndCity(@Param("status") Status status);

    @Query("SELECT count(o) FROM Account a JOIN a.opportunityList o WHERE o.status = 'OPEN' GROUP BY a.city")
    List<Object[]> countOppsByOpenAndCity(@Param("status") Status status);
     */

        /*

    //---------------- BY INDUSTRY ----------------//

    //    A count of all Opportunities by industry can be displayed by typing “Report Opportunity by Industry”
    @Query("SELECT a.industry, count(o)  FROM Account a JOIN a.opportunityList o GROUP BY a.industry")
    List<Object[] > countOpportunitiesByIndustry();

    //    A count of all CLOSED_WON Opportunities by industry can be displayed by typing “Report CLOSED-WON by Industry”
    @Query("SELECT a.industry, count(o)  FROM Account a JOIN a.opportunityList o WHERE o.status= 'CLOSED_WON' GROUP BY a.industry")
    List<Object[] > countOpportunitiesByIndustryAndStatusCLOSED_WON();

    //    A count of all CLOSED_LOST Opportunities by industry can be displayed by typing “Report CLOSED-LOST by Industry”
    @Query("SELECT a.industry, count(o)  FROM Account a JOIN a.opportunityList o WHERE o.status= 'CLOSED_LOST' GROUP BY a.industry")
    List<Object[] > countOpportunitiesByIndustryAndStatusCLOSED_LOST();

    //    A count of all OPEN Opportunities by industry can be displayed by typing “Report OPEN by Industry”
    @Query("SELECT a.industry, count(o)  FROM Account a JOIN a.opportunityList o WHERE o.status= 'OPEN' GROUP BY a.industry")
    List<Object[] > countOpportunitiesByIndustryAndStatusOPEN();

    */
}
