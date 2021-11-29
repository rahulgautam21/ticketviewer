package com.zendesk.ticketviewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

// Main of application
@SpringBootApplication
public class TicketviewerApplication {

	@Autowired
	CommandLineRunner commandLineRunner;

	public static void main(String[] args) {
		new SpringApplicationBuilder(TicketviewerApplication.class)
				.web(WebApplicationType.NONE).run(args);
	}

}
