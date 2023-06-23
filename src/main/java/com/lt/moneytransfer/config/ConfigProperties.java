package com.lt.moneytransfer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ConfigProperties {

    @Value("${application.email}")
    private String applicationEmail;

    @Value("${application.email-from}")
    private String applicationFromEmail;

}

