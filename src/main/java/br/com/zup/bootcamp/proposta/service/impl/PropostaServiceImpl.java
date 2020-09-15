package br.com.zup.bootcamp.proposta.service.impl;

import br.com.zup.bootcamp.proposta.model.Proposta;
import br.com.zup.bootcamp.proposta.repository.PropostaRepository;
import br.com.zup.bootcamp.proposta.request.NovaPropostaRequest;
import br.com.zup.bootcamp.proposta.service.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropostaServiceImpl implements PropostaService {

    private final PropostaRepository propostaRepository;

    @Override
    public Proposta criarProposta(NovaPropostaRequest request) {
        Proposta novaProposta = request.toModel();
        return propostaRepository.save(novaProposta);
    }
}
