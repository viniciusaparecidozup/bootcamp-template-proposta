package br.com.zup.bootcamp.integration.analise;

import br.com.zup.bootcamp.dto.request.SolicitacaoAnaliseRequest;
import br.com.zup.bootcamp.dto.response.SolicitacaoAnaliseResponse;
import br.com.zup.bootcamp.integration.IntegrationRoutes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SolicitacaoAnaliseIntegration {

    private final WebClient webClient;
    private final IntegrationRoutes integrationRoutes;

    public Mono<SolicitacaoAnaliseResponse> verificaRestricoes(String documento) {
        final SolicitacaoAnaliseRequest solicitacaoAnaliseRequest = new SolicitacaoAnaliseRequest(documento);
        return  this.webClient.post()
                .uri(integrationRoutes.getPostAnaliseRestricoes())
                .body(BodyInserters.fromValue(solicitacaoAnaliseRequest))
                .exchange()
                .flatMap( response -> response.body(BodyExtractors.toMono(SolicitacaoAnaliseResponse.class)));

    }
}
