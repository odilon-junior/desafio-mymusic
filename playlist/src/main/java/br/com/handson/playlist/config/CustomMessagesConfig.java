package br.com.handson.playlist.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class CustomMessagesConfig {

    private static final String MESSAGES_PATH = "messages";

    @Bean
    public MessageSource messageSource() {

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(MESSAGES_PATH);
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

}
