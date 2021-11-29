package com.zendesk.ticketviewer.constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConstants {

    @Autowired
    private Environment env;

    public static String API_URL;

    public static String API_TOKEN;

    @PostConstruct
    public void init() {
        ApplicationConstants.API_TOKEN = env.getProperty("api.token");
        ApplicationConstants.API_URL = env.getProperty("api.url");
    }

}