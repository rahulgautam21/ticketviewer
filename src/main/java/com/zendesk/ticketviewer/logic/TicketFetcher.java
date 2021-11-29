package com.zendesk.ticketviewer.logic;

import com.zendesk.ticketviewer.model.TicketResponse;
import com.zendesk.ticketviewer.model.TicketsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static com.zendesk.ticketviewer.constants.ApplicationConstants.*;

// This class is used for fetching tickets
@Component
public class TicketFetcher {

    @Autowired
    RestTemplate restTemplate;

//  Fetch multiple tickets
    public TicketsResponse fetchTickets(String url) throws Exception {
        TicketsResponse ticketsResponse = null;
        try {
            ticketsResponse = restTemplate.getForObject(url, TicketsResponse.class);
        }
        catch (HttpClientErrorException ex){
            if(ex.getRawStatusCode()==401){
                throw new Exception(UNAUTHORIZED_ERROR);
            }
            else if(ex.getRawStatusCode()==404){
                throw new Exception(INVALID_API_ERROR);
            }
        }
        catch (RestClientException ex){
            throw new Exception(INVALID_JSON_ERROR);
        }
        catch (Exception ex){
            throw new Exception(GENERIC_ERROR);
        }
        if(ticketsResponse == null){
            throw new Exception(GENERIC_ERROR);
        }
        return ticketsResponse;
    }

//  Fetch a single ticket
    public TicketResponse fetchTicket(String url) throws Exception {
        TicketResponse ticketResponse = null;
        try {
            ticketResponse = restTemplate.getForObject(url, TicketResponse.class);
        }
        catch (HttpClientErrorException ex){
            if(ex.getRawStatusCode()==401){
                throw new Exception(UNAUTHORIZED_ERROR);
            }
            else if(ex.getRawStatusCode()==404){
                throw new Exception(INVALID_API_ERROR);
            }
        }
        catch (RestClientException ex){
            throw new Exception(INVALID_JSON_ERROR);
        }
        catch (Exception ex){
            throw new Exception(GENERIC_ERROR);
        }
        if(ticketResponse == null){
            throw new Exception(GENERIC_ERROR);
        }
        return ticketResponse;
    }

}