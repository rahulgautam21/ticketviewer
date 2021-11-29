package com.zendesk.ticketviewer.configuration;

import com.zendesk.ticketviewer.constants.ApplicationConstants;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//This file contains a rest template that is used for fetching data from the API
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