package com.zendesk.ticketviewer.constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

//Contains constants used in the application
@Configuration
public class ApplicationConstants {

    @Autowired
    private Environment env;

//  URL for the API
    public static String API_URL;

//  Unique Token used for connecting to the API
    public static String API_TOKEN;

    public static String PAGE_SIZE = "25";

    public static String UNAUTHORIZED_ERROR = "Unauthorized to access the API";

    public static String INVALID_API_ERROR = "Service/API not available or is invalid";

    public static String INVALID_JSON_ERROR = "Invalid JSON received from API could not convert";

    public static String GENERIC_ERROR = "Exception occurred while fetching tickets from the API";

    @PostConstruct
    public void init() {
        ApplicationConstants.API_TOKEN = env.getProperty("api.token",System.getProperty("API_TOKEN"));
        ApplicationConstants.API_URL = env.getProperty("api.url",System.getProperty("API_URL"));
    }

}