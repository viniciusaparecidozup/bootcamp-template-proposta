package br.com.zup.bootcamp.integration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IntegrationRoutes {

    @Value("${integration.post.analise.restricoes}")
    @Getter
    private String postAnaliseRestricoes;
}
