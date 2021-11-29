package com.zendesk.ticketviewer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zendesk.ticketviewer.constants.ApplicationConstants;
import com.zendesk.ticketviewer.logic.TicketFetcher;
import com.zendesk.ticketviewer.model.Ticket;
import com.zendesk.ticketviewer.model.TicketResponse;
import com.zendesk.ticketviewer.model.TicketsResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test1")
class TicketviewerApiTests {

	@Autowired
	TicketFetcher ticketFetcher;

//	This tests that the context loads successfully and nothing breaks while autowiring
	@Test
	void contextLoads() {
		Assert.assertNotNull(ticketFetcher);
	}

//	Check Exception for Invalid Api
	@Test
	void checkExceptionForInvalidApi(){
		String url = new StringBuilder().append(ApplicationConstants.API_URL).append("dummy/").append(1).toString();
		String exceptionMessage = "";
		try {
			ticketFetcher.fetchTicket(url);
		}
		catch (Exception ex){
			exceptionMessage = ex.getMessage();
		}
		Assert.assertEquals(ApplicationConstants.INVALID_API_ERROR,exceptionMessage);
	}

//	Check that able to deserialize a json
	@Test
	void checkNoExceptionForValidJson(){
		String jsonTicket = "{\n" +
				"    \"ticket\": {\n" +
				"        \"url\": \"https://zcczendeskcodingchallenge9230.zendesk.com/api/v2/tickets/1.json\",\n" +
				"        \"id\": 1,\n" +
				"        \"external_id\": null,\n" +
				"        \"via\": {\n" +
				"            \"channel\": \"sample_ticket\",\n" +
				"            \"source\": {\n" +
				"                \"from\": {},\n" +
				"                \"to\": {},\n" +
				"                \"rel\": null\n" +
				"            }\n" +
				"        },\n" +
				"        \"created_at\": \"2021-11-19T22:06:10Z\",\n" +
				"        \"updated_at\": \"2021-11-27T03:42:05Z\",\n" +
				"        \"type\": \"incident\",\n" +
				"        \"subject\": \"Sample ticket: Meet the ticket\",\n" +
				"        \"description\": \"Hi there,\\n\\nI’m sending an email because I’m having a problem setting up your new product. Can you help me troubleshoot?\\n\\nThanks,\\n The Customer\\n\\n\",\n" +
				"        \"priority\": \"normal\",\n" +
				"        \"status\": \"open\",\n" +
				"        \"requester_id\": 1523684992461,\n" +
				"        \"tags\": [\n" +
				"            \"sample\",\n" +
				"            \"support\",\n" +
				"            \"zendesk\"\n" +
				"        ]\n" +
				"    }\n" +
				"}";
		ObjectMapper mapper = new ObjectMapper();
		Exception ex = null;
		try {
			TicketResponse wrapper = mapper.readValue(jsonTicket, TicketResponse.class);
		} catch (JsonProcessingException e) {
			ex = e;
		}
		Assert.assertNull(ex);
	}

//	Invalid Json by setting the id as dummy
	@Test
	void checkExceptionForInValidJson(){
		String jsonTicket = "{\n" +
				"    \"ticket\": {\n" +
				"        \"id\": \"dummy\",\n" +
				"        \"external_id\": null,\n" +
				"        \"via\": {\n" +
				"            \"channel\": \"sample_ticket\",\n" +
				"            \"source\": {\n" +
				"                \"from\": {},\n" +
				"                \"to\": {},\n" +
				"                \"rel\": null\n" +
				"            }\n" +
				"        },\n" +
				"        \"created_at\": \"2021-11-19T22:06:10Z\",\n" +
				"        \"updated_at\": \"2021-11-27T03:42:05Z\",\n" +
				"        \"type\": \"incident\",\n" +
				"        \"subject\": \"Sample ticket: Meet the ticket\",\n" +
				"        \"description\": \"Hi there,\\n\\nI’m sending an email because I’m having a problem setting up your new product. Can you help me troubleshoot?\\n\\nThanks,\\n The Customer\\n\\n\",\n" +
				"        \"priority\": \"normal\",\n" +
				"        \"status\": \"open\",\n" +
				"        \"requester_id\": 1523684992461,\n" +
				"        \"tags\": [\n" +
				"            \"sample\",\n" +
				"            \"support\",\n" +
				"            \"zendesk\"\n" +
				"        ]\n" +
				"    }\n" +
				"}";
		ObjectMapper mapper = new ObjectMapper();
		Exception ex = null;
		TicketResponse wrapper;
		try {
			wrapper = mapper.readValue(jsonTicket, TicketResponse.class);
		} catch (JsonProcessingException e) {
			System.out.println(e);
			ex = e;
		}

		Assert.assertNotNull(ex);
	}



}