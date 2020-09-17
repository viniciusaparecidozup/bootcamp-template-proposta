package br.com.zup.bootcamp.service.impl;

import br.com.zup.bootcamp.dto.request.NovaPropostaRequest;
import br.com.zup.bootcamp.model.Proposta;
import br.com.zup.bootcamp.repository.PropostaRepository;
import br.com.zup.bootcamp.service.PropostaService;
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
