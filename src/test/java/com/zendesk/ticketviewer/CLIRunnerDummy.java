package com.zendesk.ticketviewer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// This is a dummy bean created so that spring does not run the main method
@Component
public class CLIRunnerDummy implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }
}
