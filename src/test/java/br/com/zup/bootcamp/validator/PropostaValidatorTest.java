package br.com.zup.bootcamp.validator;

import br.com.zup.bootcamp.model.Proposta;
import br.com.zup.bootcamp.repository.PropostaRepository;
import br.com.zup.bootcamp.stub.PropostaStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PropostaValidatorTest {

    @InjectMocks
    private PropostaValidator propostaValidator;

    @Mock
    private PropostaRepository propostaRepository;

    @Test
    @DisplayName("nao pode processar proposta com documento igual")
    void bloqueiaCriacaoDePropostaNoMesmoNumeroDocumento() {
        final Proposta proposta = PropostaStub.criaPropostaCpf();
        when(propostaRepository.findByDocumento(anyString())).
                thenReturn(Optional.of(proposta));
        Assertions.assertThrows(ResponseStatusException.class, () -> {
            propostaValidator.bloqueiaCriacaoDePropostaNoMesmoNumeroDocumento(proposta.getDocumento());
        });
    }

    @Test
    @DisplayName("deve prosseguir sem encontrar proposta")
    void deveCriacaoDePropostaNoMesmoNumeroDocumento() {
        final Proposta proposta = PropostaStub.criaPropostaCpf();
        when(propostaRepository.findByDocumento(anyString())).
                thenReturn(Optional.empty());
        propostaValidator.bloqueiaCriacaoDePropostaNoMesmoNumeroDocumento(proposta.getDocumento());
    }
}