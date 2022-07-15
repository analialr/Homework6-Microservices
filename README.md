# __ FUNNY WEIRDOS CRM  ___ by The RUTHs 


## Table of Contents

1. [**Requirements**](#Requirements)
2. [**Existing Project Structure**](#Existing-Project-Structure)
3. [**SetUp**](#SetUp)
3. [**Services**](#Services)


## Requirements  __ HOMEWORK 6

As a team, decide the best microservice architecture. Consider where edge services might be advantageous and necessary
individual services. Make sure that you are designing together how the application will be broken into services before
starting.

Then, rebuild the exact project from the ground up utilizing microservices architecture and creating API routes for
every current CLI command.

Remember to make the application as robust as possible.

## Existing Project Structure

<a href="https://github.com/ES-IH-JAVAFT-MAY22/Homework3-MontyJava"> MontyJava_Homework-3 </a>



## SETUP:

* Use this repository with the externalize configuration.application.<a href="https://github.com/sofidelaf/config-repo.git"> SERVER.CONFIG</a>
* When requesting on postman from the http://localhost:8080  :

    *  EUREKA SERVER       ||  8761
    *  EDGE SERVICE        ||  8080
    
    *  LEAD-SERVICE        ||  8081
    *  OPPORTUNITY-SERVICE ||  8082
    *  SALESREP-SERVICE    ||  8083
    *  ACCOUNT-SERVICE     ||  8084
    *  CONTACT-SERVICE     ||  8085


## SERVICES:


| Port | Route Type |                  Route                 |            Input Required           |    Service Called   |
|:----:|:----------:|:--------------------------------------:|:-----------------------------------:|:-------------------:|
| 8081 | POST       | "/new-lead"                            | Lead lead                           | LEAD-SERVICE        |
| 8083 | POST       | "/new-salesrep"                        | SalesRep salesRep                   | SALESREP-SERVICE    |
| 8084 | POST       | "/new-account"                         | Account account                     | ACCOUNT-SERVICE     |
| 8081 | POST       | "/convert-leads"                       | Long:id , Opportunity opportunity   | LEAD-SERVICE        |
| 8084 | GET        | "/max-employee-count"                  |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/min-employee-count"                  |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/mean-employee-count"                 |                                     | ACCOUNT-SERVICE     |
| 8082 | GET        | "/mean-product-quantity"               |                                     | OPPORTUNITY-SERVICE | 
| 8082 | GET        | "/max-product-quantity"                |                                     | OPPORTUNITY-SERVICE |
| 8082 | GET        | "/min-product-quantity"                |                                     | OPPOTUNITY-SERVICE  |
| 8081 | GET        | "/leads-by-salesrep"                   |                                     | LEAD-SERVICE        |
| 8082 | GET        | "/count-opp-by-product"                |                                     | OPPORTUNITY-SERVICE |
| 8082 | GET        | "/count-opp-by-product-closed-won"     |                                     | OPPORTUNITY-SERVICE |
| 8082 | GET        | "/count-opp-by-product-closed-lost"    |                                     | OPPORTUNITY-SERVICE |
| 8082 | GET        | "/count-opp-by-product-open"           |                                     | OPPORTUNITY-SERVICE |
| 8084 | GET        | "/opps-by-city"                        |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-by-close-won-city "             |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-by-close-lost-city"             |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-open-by-city"                   |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-by-industry"                    |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-by-industry-close-won"          |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-by-industry-close-lost"         |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-by-industry-open"               |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-by-open-country"                |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-by-losewon-country"             |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-by-closewon-country"            |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/opps-by-country"                     |                                     | ACCOUNT-SERVICE     |
| 8081 | GET        | "/show-leads"                          |                                     | LEAD-SERVICE        |
| 8081 | GET        | "/lookup-lead/{id}"                    | long: id                            | LEAD-SERVICE        |
| 8084 | GET        | "/show-accounts"                       |                                     | ACCOUNT-SERVICE     |
| 8084 | GET        | "/lookup-account/{id}"                 | Long: id                            | ACCOUNT-SERVICE     |
| 8085 | GET        | "/show-contacts"                       |                                     | CONTACT-SERVICE     |
| 8085 | GET        | "/lookup-contact/{id}"                 | Long: id                            | CONTACT-SERVICE     |
| 8082 | GET        | "/show-opportunities"                  |                                     | OPPORTUNITY-SERVICE |
| 8082 | GET        | "/lookup-opportunity/{id}"             | Long: id                            | OPPORTUNITY-SERVICE |
| 8083 | GET        | "/new-salesrep"                        |                                     | SALESREP-SERVICE    |
| 8083 | GET        | "/lookup-opportunity/{id}"             | Long: id                            | SALESREP-SERVICE    |



## The Ruth's Team 

- Ruth Telleria 
- Sofia de la Fuente 
- Analia Lopez Rodriguez 
- Vedrana Hasanbasic 
- Lucia de Haro
