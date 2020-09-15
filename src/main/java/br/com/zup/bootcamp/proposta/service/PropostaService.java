package br.com.zup.bootcamp.proposta.service;

import br.com.zup.bootcamp.proposta.model.Proposta;
import br.com.zup.bootcamp.proposta.request.NovaPropostaRequest;

public interface PropostaService {

    Proposta criarProposta(NovaPropostaRequest request);
}
