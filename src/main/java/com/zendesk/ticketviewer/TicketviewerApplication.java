package com.zendesk.ticketviewer;

import com.zendesk.ticketviewer.constants.ApplicationConstants;
import com.zendesk.ticketviewer.logic.TicketFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TicketviewerApplication implements CommandLineRunner {

	@Autowired
	TicketFetcher ticketFetcher;

	public static void main(String[] args) {
		SpringApplication.run(TicketviewerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(ApplicationConstants.API_URL);
		System.out.println(ApplicationConstants.API_TOKEN);
		System.out.println(ticketFetcher.fetchTickets());
	}
}
