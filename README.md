# Saving Private's Bike

Or the considarations behind implementing a job scheduler.

## Introduction

The Problem definition stated as follows:
Due an increase in report of stolen bikes, we need to have a service which assign open cases to available officers. After closing each case, officer should be ready to accept next case. We also need a report revealing statics of implemented API.

Providing an API for a GUI app is your job. You dont need to worry about front-end side.

## Analyzing

The nature of this task is to implement a job scheduler. A job scheduler is a service which assign pending jobs to available job consumers. There are some aspects which needs to consider:

1. **Choosing a Database or Message Queue**
   database cons and pros

   it's not 2003 anymore
   a need to archiving results.

2. **In-memory Database vs relational database**
   cons and pros

3. **Scability**
   Horizontal, Vertical

4. **Race Conditions and Dead_locks**
   Considering nature of a web service and the way each request is going to process also taking horizontal scability into considiration Race Conditions are inevitable.
   Therefore we must figure out a mitigation for this issue.
   And the usual solution for it would be using dead locks, which block access to a specific row by two thread simultaneously.

5. **Desiging Database**

6. **Why Spring?**

7. **Desiging API (swagger)**

8. **How to test service?**
