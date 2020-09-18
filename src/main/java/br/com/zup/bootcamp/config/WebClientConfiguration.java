package br.com.zup.bootcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Bean
    @Description("Proposta web client")
    public WebClient restClient(){
        return WebClient.builder()
                .build();
    }

}
