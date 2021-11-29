package com.zendesk.ticketviewer.logic;

import com.zendesk.ticketviewer.constants.ApplicationConstants;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfiguration {

//  We create a rest template and add the authorization header with the API token
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.additionalInterceptors((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + ApplicationConstants.API_TOKEN);
            return execution.execute(request, body);})
            .build();
    }

}