# Zendesk-Coding-Challenge - Rahul Gautam

This is a command line interface application created using Java. The application 
makes HTTP requests to Zendesk API to allow the user to retrieve tickets and display
their information.

## Prerequisite

- [Java](https://www.java.com/download/ie_manual.jsp) v8 or greater is preferred
- Although Intellij can be used to edit and gothrough the code any IDE that supports Java will work. The code 
can also be run standalone using Jar.

## How to run

1. Download the repository to your local machine with the following code.

```
$ git clone https://github.com/rahulgautam21/ticketviewer.git
```

2. Navigate to the repository

3. Run the program with the below command

```
$ java -DAPI_TOKEN="be2dbe345e3eb54a4fdc413cda9833782aa4a55a4692a6c4f9a2ec527fdeca51" -DAPI_URL="https://zcczendeskcodingchallenge9230.zendesk.com/api/v2/" -jar ticketviewer.jar
```

4. To run using Intellij   

Specify main class as : com.zendesk.ticketviewer.TicketviewerApplication  
Specify JVM arguments : -DAPI_TOKEN=be2dbe345e3eb54a4fdc413cda9833782aa4a55a4692a6c4f9a2ec527fdeca51  -DAPI_URL=https://zcczendeskcodingchallenge9230.zendesk.com/api/v2/



To protect authentication credentials I use API token instead of passing username and password  

5. To run tests, run them using the below command

```
$ gradlew test 
```

6. To generate jar, use the below command

```
gradlew fatJar
```

This will create a new fatjar in build/libs directory with the name ticketviewer-0.0.1-SNAPSHOT-all.jar which can be
used with the new changes to the code

## Design Overview

### Assumptions
- We assume that the user is familiar with basic command line execution or using Intellij to run the code

### Description of the Code

The code is structured into multiple packages based on the functionality

- ```configuration``` : Contains configuration objects such as code for making rest call configuration
- ```constants``` : Contains classes that have constants used across the application
- ```helper``` : Contains helper classes. Utility class such as printing a ticket information
- ```logic``` : Contains logic classes. CLIRunner contains code for how the user selects options
and interacts with the CLI. TicketFetcher contains code to fetch tickets from the API
- ```model``` : Contains models of how JSONs correspond to Java objects

### Authentication

From the developer guide, it is evident that we should not use basic authentication for 
querying the API we use OAuth for authentication. The API token is passed as a command line 
argument so that the user credentials are always secure.

### Displaying tickets

I have selected only some attributes based on their relevance for printing so that the tickets
convey basic information and still remain concise and not cumbersome
1. For multiple tickets I display the tickets in a tabular format with the headers - Id, Subject, Requester Id, Tags, Updated Timestamp
2. For a singular ticket I display the ticket information in a sequential format and also add the ticket description.

### Paging

The default page size is 25. However, it can be modified from the Application Constants file.  
Since the API supports paging with support for the page size and the page we want to access we keep incrementing the page
as long as the user wants to query. The user can keep pressing a key to access the next page similar to how a MAN page in UNIX works.

### Testing

For testing, I have created test cases around cases of authentication failures, Invalid API requests and Invalid API responses

## Resources

I found the below Zendesk links very helpful in creating this project

- [Oauth 2.0](https://developer.zendesk.com/documentation/ticketing/working-with-oauth/creating-and-using-oauth-tokens-with-the-api)
Creating API tokens for our accessing Ticket data

- [Tickets](https://developer.zendesk.com/api-reference/ticketing/tickets/tickets)
This link contains the ticket endpoints documentation

- [Pagination](https://developer.zendesk.com/rest_api/docs/support/introduction#pagination)
This contains how to make pagination calls