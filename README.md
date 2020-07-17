# Saving Private's Bike

Or the considarations behind implementing a job scheduler.

## Introduction

The Problem definition stated as follows:
Due an increase in report of stolen bikes, we need to have a service which assign open cases to available officers. After closing each case, officer should be ready to accept next case. We also need a report revealing statics of implemented API.

Providing an API for a GUI app is your job. You dont need to worry about front-end side.

## Analyzing

The nature of this task is to implement a job scheduler. A job scheduler is a service which assign pending jobs to available job consumers. There are some aspects which needs to consider:

1. Choosing a Database or Message Queue

   database cons and pros
   it's not 2003 anymore
   a need to archiving results.

2. In-memory Database vs relational database

   cons and pros

3. Scability

   Horizontal, Vertical

4. Race Conditions and Dead_locks

   Considering nature of a web service and the way each request is going to process also taking horizontal scability into considiration Race Conditions are inevitable.
   Therefore we must figure out a mitigation for this issue.
   And the usual solution for it would be using dead locks, which block access to a specific row by two thread simultaneously.

5. Designing Database

   - Officers
      | officer_id   | officer_status   | last_case   | case_id|
      | ---          | ---              | ---         | ---    |

   - Cases
      | case_id   | case_status  | officer|
      | ---       | ---          | ---    |

   - Officers_data(Optional)
      | officer_id   | name |
      | ---          | ---  |

   - Cases_data(Optional)
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

     In order to design a databse we have to apply normalization rules. For this case applying till the third level seams enough.

     One the consideration during Designing DB is to try it design on a way that to decrease amount of logical read.

     In order to achieve that we're going to decrease amount of data we read during bonding an officer and a case together, so by spliting each table (Cases, Officers) into necessary data and extra data.

6. Why Spring?

   Microservices, Spring boot, ...

7. Designing API (swagger)

   see proper page.

8. Connecting to Database

9. How to test service?

   gotta trust on the hooman.
