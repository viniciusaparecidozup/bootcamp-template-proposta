package br.com.zup.bootcamp.resources;

import br.com.zup.bootcamp.dto.request.NovaPropostaRequest;
import br.com.zup.bootcamp.dto.response.NovaPropostaResponse;
import br.com.zup.bootcamp.model.Proposta;
import br.com.zup.bootcamp.service.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class PropostaResource {

    private static final String PROPOSTA_CRIADA = "/propostas/{id}";
    private final PropostaService propostaService;

    @PostMapping(value = Routes.CRIAR_PROPOSTA)
    public ResponseEntity<NovaPropostaResponse> criar(
            @RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder builder) {
        Proposta proposta = propostaService.criarProposta(request);
        final NovaPropostaResponse novaPropostaResponse = NovaPropostaResponse.toResponse(proposta);
        return ResponseEntity.created(builder
                .buildAndExpand(PROPOSTA_CRIADA, proposta.getId())
                .toUri()).body(novaPropostaResponse);
    }

}
