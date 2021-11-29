package com.zendesk.ticketviewer.logic;

import com.zendesk.ticketviewer.constants.ApplicationConstants;
import com.zendesk.ticketviewer.model.Ticket;
import com.zendesk.ticketviewer.model.TicketsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TicketFetcher {

    @Autowired
    RestTemplate restTemplate;

    public List<Ticket> fetchTickets(){
        TicketsResponse ticketsResponse = restTemplate.getForObject(
                ApplicationConstants.API_URL+"tickets", TicketsResponse.class);
        List<Ticket> tickets = ticketsResponse.getTickets();
        return tickets;
    }

}