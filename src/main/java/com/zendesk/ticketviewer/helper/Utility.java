package com.zendesk.ticketviewer.helper;

import com.zendesk.ticketviewer.model.Ticket;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

//Utility class for helper functions like printing tickets and headers columns
public class Utility {

    public static void displayAllTickets(List<Ticket> tickets){
        for(Ticket ticket : tickets){
            System.out.printf("| %10s | %25s | %15s | %25s | %20s |\n",ticket.getId().toString(),
                    StringUtils.abbreviate(ticket.getSubject(),24),ticket.getRequesterId().toString(),StringUtils.abbreviate(ticket.getTags().toString(),25),
                    ticket.getUpdatedAt());
        }
    }

    public static void displayHeader(){
        System.out.printf("| %10s | %25s | %15s | %25s | %20s |\n","ID","SUBJECT","REQUESTER_ID","TAGS","UPDATED_TIMESTAMP");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    public static void displayTicket(Ticket ticket){
        System.out.println("Details of ticket are :");
        String description = "";
        String originalDescription = ticket.getDescription();
        while(originalDescription.length()>0){
            description += originalDescription.substring(0,Math.min(50,originalDescription.length())) + "\n";
            originalDescription = originalDescription.substring(Math.min(50,originalDescription.length()));
        }
        System.out.printf("Subject : %s \nRequester Id : %s\nDescription :\n %s \nTags : %s\nUpdated At : %s\n", ticket.getSubject(), ticket.getRequesterId(),
                description, ticket.getTags().toString(),ticket.getUpdatedAt());
    }
}
