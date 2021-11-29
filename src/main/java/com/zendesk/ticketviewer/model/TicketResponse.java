package com.zendesk.ticketviewer.model;

// Wrapper Model for mapping output of API to a ticket as ticket is wrapped
public class TicketResponse {

    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}