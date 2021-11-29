package com.zendesk.ticketviewer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

// Wrapper Model for mapping output of API for multiple tickets
public class TicketsResponse {

   private List<Ticket> tickets;

   @JsonProperty("next_page")
   String nextPage;

   public List<Ticket> getTickets() {
      return tickets;
   }

   public void setTickets(List<Ticket> tickets) {
      this.tickets = tickets;
   }

   public String getNextPage() {
      return nextPage;
   }

   public void setNext_page(String nextPage) {
      this.nextPage = nextPage;
   }
}