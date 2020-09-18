package br.com.zup.bootcamp.service.impl;

import br.com.zup.bootcamp.dto.request.NovaPropostaRequest;
import br.com.zup.bootcamp.model.Proposta;
import br.com.zup.bootcamp.repository.PropostaRepository;
import br.com.zup.bootcamp.stub.PropostaStub;
import br.com.zup.bootcamp.validator.PropostaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PropostaServiceImplTest {

    @Mock
    private PropostaRepository propostaRepository;
    @Mock
    private PropostaValidator propostaValidator;

    @InjectMocks
    private PropostaServiceImpl propostaService;

    @Test
    @DisplayName("cria proposta com cpf")
    void criarProposta() {
        final Proposta proposta = PropostaStub.criaPropostaCpf();
        when(propostaRepository.save(any(Proposta.class))).
                thenReturn(proposta);
        final NovaPropostaRequest novaPropostaRequest = PropostaStub.criaPropostaCpf(NovaPropostaRequest.class);
        final Proposta propostaSalva = propostaService.criarProposta(novaPropostaRequest);
        Assertions.assertNotNull(proposta);
        Assertions.assertEquals(novaPropostaRequest.getDocumento(), propostaSalva.getDocumento());
    }

    @Test
    @DisplayName("não cria proposta, cpf já existe proposta")
    void naoCriarPropostaCpfExistente() {
        final Proposta proposta = PropostaStub.criaPropostaCpf();
        doThrow(ResponseStatusException.class)
                .when(propostaValidator);
        final NovaPropostaRequest novaPropostaRequest = PropostaStub.criaPropostaCpf(NovaPropostaRequest.class);
        propostaService.criarProposta(novaPropostaRequest);
        Assertions.assertThrows(ResponseStatusException.class, () -> {
            propostaValidator.bloqueiaCriacaoDePropostaNoMesmoNumeroDocumento(proposta.getDocumento());
        });
    }
}