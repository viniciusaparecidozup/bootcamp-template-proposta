package br.com.zup.bootcamp.validator;

import br.com.zup.bootcamp.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class PropostaValidator {

    private final PropostaRepository propostaRepository;

    public void bloqueiaCriacaoDePropostaNoMesmoNumeroDocumento(String documento) {
        propostaRepository.findByDocumento(documento)
                .ifPresent(p -> {
                    throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
                });
    }
}
