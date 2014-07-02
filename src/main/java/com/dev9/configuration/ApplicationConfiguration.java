package com.dev9.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    /**
     * This method will return a string of a static "name" for the application.  This is not the preferred way of doing this,
     * use a property placeholder instead.  This method is only created and used to demonstrate how to do simple Java Configuration for Spring
     *
     * @return String
     */
    @Bean(name = "applicationName")
    public String getApplicationName() {
        return "Simple Demo Webapp";
    }

    /**
     * Same as above, used for demo purposes only. Strongly do not recommend using java configuration for version stuff
     *
     * @return String
     */
    @Bean(name = "applicationVersion")
    public String getApplicationVersion() {
        return "1.0";
    }
}
