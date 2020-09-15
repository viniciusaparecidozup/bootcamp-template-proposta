package br.com.zup.bootcamp.proposta.resources;

import javax.validation.Valid;

import br.com.zup.bootcamp.proposta.request.NovaPropostaRequest;
import br.com.zup.bootcamp.proposta.response.NovaPropostaResponse;
import br.com.zup.bootcamp.proposta.service.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.bootcamp.proposta.model.Proposta;
import br.com.zup.bootcamp.proposta.repository.PropostaRepository;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@AllArgsConstructor
public class NovaPropostaResource {

    private final PropostaService propostaService;

    private static final String PROPOSTA_CRIADA = "/propostas/{id}";

    @PostMapping(value = Routes.CRIAR_PROPOSTA)
    @Transactional
    public ResponseEntity<NovaPropostaResponse> cria(
            @RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder builder) {
        Proposta proposta = propostaService.criarProposta(request);
        final NovaPropostaResponse novaPropostaResponse = NovaPropostaResponse.toResponse(proposta);
        return ResponseEntity.created(builder
                .buildAndExpand(PROPOSTA_CRIADA,proposta.getId())
                .toUri()).body(novaPropostaResponse);
    }

}
