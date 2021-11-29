package com.zendesk.ticketviewer.logic;

import com.zendesk.ticketviewer.constants.ApplicationConstants;
import com.zendesk.ticketviewer.helper.Utility;
import com.zendesk.ticketviewer.model.Ticket;
import com.zendesk.ticketviewer.model.TicketResponse;
import com.zendesk.ticketviewer.model.TicketsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

// CLI that the user interacts with
@Component
@Profile("default")
public class CLIRunner implements CommandLineRunner {

    @Autowired
    TicketFetcher ticketFetcher;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to the Ticket Viewer Application");
        Scanner scanner = new Scanner(System.in);
        char c = 'x';
        boolean exit=false;
        while (!exit){
            System.out.println("1 : Press 1 to view all Tickets");
            System.out.println("2 : Press 2 to view a Ticket");
            System.out.println("q : Enter q to quit");
            String s = scanner.nextLine().trim();
            if(s.length()>0)
                c = s.charAt(0);
            else
                c = '0';
            if(c=='q'){
                exit = true;
            }
//          Case for fetching all tickets
            if(c=='1'){
                boolean hasTickets = true;
                int pageNumber = 1;
                while(hasTickets) {
                    String url = new StringBuilder().append(ApplicationConstants.API_URL).append("tickets?per_page=").append(ApplicationConstants.PAGE_SIZE).append("&page=").append(pageNumber).toString();
                    TicketsResponse ticketsResponse = null;
                    try {
                        ticketsResponse = ticketFetcher.fetchTickets(url);
                    }
                    catch (Exception ex){
                        System.out.println(ex.getMessage());
                        break;
                    }
                    List<Ticket> tickets = ticketsResponse.getTickets();
                    Utility.displayHeader();
                    Utility.displayAllTickets(tickets);
//                  Check if next page is available, and we can browse any more tickets
                    if(ticketsResponse.getNextPage() == null){
                        hasTickets = false;
                        System.out.println("No More Tickets left to browse");
                    }
                    else{
                        System.out.println("To continue browsing next set of tickets press any key else press c");
                        String line = scanner.nextLine();
                        if(line.trim().length()>0)
                            c = line.trim().charAt(0);
                        if(c=='c' || c=='C')
                            hasTickets = false;
                        if(c=='q'){
                            hasTickets = false;
                            exit = true;
                        }
                        pageNumber+=1;
                    }
                }
            }
//          Case for querying a ticket by id
            if(c=='2'){
                System.out.println("Enter the ticket id");
                long id = -1;
                try {
                    id = scanner.nextLong();
                }
                catch (Exception ex){
                    scanner.nextLine();
                    System.out.println("Invalid ticket id");
                    continue;
                }
                String url = new StringBuilder().append(ApplicationConstants.API_URL).append("tickets/").append(id).toString();
                TicketResponse ticketResponse = null;
                try {
                    ticketResponse = ticketFetcher.fetchTicket(url);
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
                if(ticketResponse!=null){
                    Utility.displayTicket(ticketResponse.getTicket());
                }
                scanner.nextLine();
            }
        }
        System.out.println("Exiting Ticket Viewer Application");
    }
}
