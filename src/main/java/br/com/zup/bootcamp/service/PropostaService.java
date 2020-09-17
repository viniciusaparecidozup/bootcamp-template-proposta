package br.com.zup.bootcamp.service;

import br.com.zup.bootcamp.dto.request.NovaPropostaRequest;
import br.com.zup.bootcamp.model.Proposta;

public interface PropostaService {

    Proposta criarProposta(NovaPropostaRequest request);
}
