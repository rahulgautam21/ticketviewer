package com.zendesk.ticketviewer;

import com.zendesk.ticketviewer.constants.ApplicationConstants;
import com.zendesk.ticketviewer.logic.TicketFetcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.*;

@SpringBootTest
@ActiveProfiles("test")
class TicketviewerAuthorizationTests {

	@Autowired
	TicketFetcher ticketFetcher;

//	This tests that the context loads successfully and nothing breaks while autowiring
	@Test
	void contextLoads() {
		Assert.assertNotNull(ticketFetcher);
	}

	@Test
	void checkExceptionForUnauthorized(){
		String url = new StringBuilder().append(ApplicationConstants.API_URL).append("tickets/").append(1).toString();
		String exceptionMessage = "";
		try {
			ticketFetcher.fetchTicket(url);
		}
		catch (Exception ex){
			exceptionMessage = ex.getMessage();
		}
		Assert.assertEquals(ApplicationConstants.UNAUTHORIZED_ERROR,exceptionMessage);
	}

}