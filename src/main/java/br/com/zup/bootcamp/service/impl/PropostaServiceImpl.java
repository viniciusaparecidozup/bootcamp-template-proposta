package br.com.zup.bootcamp.service.impl;

import br.com.zup.bootcamp.dto.request.NovaPropostaRequest;
import br.com.zup.bootcamp.model.Proposta;
import br.com.zup.bootcamp.repository.PropostaRepository;
import br.com.zup.bootcamp.service.PropostaService;
import br.com.zup.bootcamp.validator.PropostaValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropostaServiceImpl implements PropostaService {

    private final PropostaRepository propostaRepository;
    private final PropostaValidator propostaValidator;

    @Override
    public Proposta criarProposta(NovaPropostaRequest request) {
        propostaValidator.bloqueiaCriacaoDePropostaNoMesmoNumeroDocumento(request.getDocumento());
        propostaValidator.checaRestricaoDocumento(request.getDocumento());
        Proposta novaProposta = request.toModel();
        return propostaRepository.save(novaProposta);
    }


}
