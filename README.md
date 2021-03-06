# Saving Private's Bike

Or the considerations behind implementing a job scheduler.

## Introduction

The Problem definition stated as follows:
Due an increase in report of stolen bikes, we need to have a service which assign open cases to available officers. After closing each case, officer should be ready to accept next case. We also need a report revealing statics of implemented API.

Providing an API for a GUI app is your job. You don't need to worry about front-end side.

## Analyzing

The nature of this task is to implement a job scheduler. A job scheduler is a service which assign pending jobs to available job consumers. There are some aspects which needs to consider:

1. Choosing a Database or Message Queue

   Modern databases can easily handle up to 1000 Request Per Second and higher without any problem. Indexing and searching will not be an issue for modern databases.

   Because of nature of out problem we alse need to keep a record of our cases.

2. In-memory Database vs relational database

   In-memory Database are fast but unfortunatly are vulnerable to loss of power, any technical problem lead to lose our data. In contrast relational databases store date on HDD so we're no longer worry about lose of data.

3. Scalability

   During design of this scheduler I should consider horizental scability. This service must design in a way that could be easily clusterized. Making concurency problem more obvious. And 

4. Race Conditions and Dead_locks

   Considering nature of a web service and the way each request is going to process also taking horizontal Scalability into consideration Race Conditions are inevitable.
   Therefore we must figure out a mitigation for this issue.
   And the usual solution for it would be using dead locks, which block access to a specific row by two thread simultaneously.

5. Designing Database

   - Officers
      | officer_id   | officer_status   | last_case   | case_id|
      | ---          | ---              | ---         | ---    |

   - Cases
      | case_id   | case_status  | officer|
      | ---       | ---          | ---    |

   - Officers_data( Optional)
      | officer_id   | name |
      | ---          | ---  |

   - Cases_data( Optional)
      | case_id   | desc   | date_added   | national_id  |
      | ---       | ---    | ---          | ---          |

   - Enums
      | officer_status   |
      | ---              |
      | BUSY             |
      | FREE             |

      | case_status  |
      | ---          |
      | PENDING      |
      | WORKING      |
      | DONE         |

   - Discussion

     In order to design a database we have to apply normalization rules. For this case applying till the third level seams enough.

     One the consideration during Designing DB is to try it design on a way that to decrease amount of logical read.

     In order to achieve that we're going to decrease amount of data we read during bonding an officer and a case together, so by splitting each table (Cases, Officers) into necessary data and extra data.

6. Why Spring?

   Microservices, Spring boot, ...

7. Designing API

   Also Swagger-ui is available at "http://localhost:8080/swagger-ui.html"

   Verb   | URI                                    |  Description
   ---    | ---                                    | ---
   GET    | /cases/                                | Get all cases
   GET    | /cases/?state=[PENDING/WORKING/DONE]   | Get all cases filtering by
   GET    | /cases/{case_id}                       | Get Description on case
   DELETE | /cases/{case_id}                       | Delete case
   POST   | /cases/                                | Add new case
   GET    | /officers/                             | Get all officers
   GET    | /officers/?state=[FREE/BUSY]           | Get all officers filtering by
   GET    | /officers/{officers_id}                | Get Officer details
   DELETE | /officers/{officers_id}                | Delete Officer
   PATCH  | /officers/{officers_id}                | Officer's Job Done

8. Connecting to Database

   In the study phase it was set to use MySql DB as the backend database, but for the sake of simpleness and delivering a MVP I used H2.
   Although It was quite simple to use SQL in order to talk to the database (personally), I chose to use Spring Data JPA. It is remarkably more simple but needs to spare time to fully get understood it.

9. Avoiding number Ids

   In order to achieve this requirement we're going to use Internal Hibernate's UUID. This item makes sure each value is random and unique.

10. This project's Issues

    - Due to lack of time, Validations didn't implemented.
    - Exceptions has'nt handled properly.
    - Race Conditions and locking mechanism haven't driven yet.
    - When program starts Idle officers stays Idle.

11. Docker!

    $ ./docker-run.sh

    Runs docker-compose, and exposes internal port to the world.

    In case of any difficulty check Docker documentations.

12. How to test service?

    404 Not Found
