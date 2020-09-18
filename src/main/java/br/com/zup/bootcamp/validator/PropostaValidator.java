package br.com.zup.bootcamp.validator;

import br.com.zup.bootcamp.dto.enums.ResultadoSolicitacao;
import br.com.zup.bootcamp.dto.response.SolicitacaoAnaliseResponse;
import br.com.zup.bootcamp.integration.analise.SolicitacaoAnaliseIntegration;
import br.com.zup.bootcamp.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Log
public class PropostaValidator {

    private final PropostaRepository propostaRepository;
    private final SolicitacaoAnaliseIntegration solicitacaoAnaliseIntegration;
    private static final String MSG_COM_RESTRICAO = "Encontradas restrições no documento enviado";

    public void bloqueiaCriacaoDePropostaNoMesmoNumeroDocumento(String documento) {
        propostaRepository.findByDocumento(documento)
                .ifPresent(p -> {
                    throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
                });
    }

    public void checaRestricaoDocumento(String documento) {
        final Mono<SolicitacaoAnaliseResponse> solicitacaoAnaliseResponseMono =
                solicitacaoAnaliseIntegration.verificaRestricoes(documento);
        solicitacaoAnaliseResponseMono
            .doOnNext(solicitacaoAnaliseResponse -> {
                if (ResultadoSolicitacao.COM_RESTRICAO.equals(solicitacaoAnaliseResponse.getResultadoSolicitacao())){
                    log.warning(MSG_COM_RESTRICAO + documento);
                    throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, MSG_COM_RESTRICAO);
                }
            }).subscribe();

    }
}
