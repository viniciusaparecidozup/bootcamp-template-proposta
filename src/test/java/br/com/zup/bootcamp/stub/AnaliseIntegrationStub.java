package br.com.zup.bootcamp.stub;

import br.com.zup.bootcamp.dto.enums.ResultadoSolicitacao;
import br.com.zup.bootcamp.dto.request.SolicitacaoAnaliseRequest;
import br.com.zup.bootcamp.dto.response.SolicitacaoAnaliseResponse;

import javax.validation.constraints.NotNull;

public class AnaliseIntegrationStub {

    private static final String CPF = "338.303.080-60";

    public static SolicitacaoAnaliseRequest buildSolicitacaoRequest() {
        return new SolicitacaoAnaliseRequest(CPF);
    }

    public static SolicitacaoAnaliseResponse buildSolicitacaoResponse(@NotNull ResultadoSolicitacao
                                                                              resultadoSolicitacao) {
        return SolicitacaoAnaliseResponse
                .builder()
                .documento(CPF)
                .idProposta("1")
                .resultadoSolicitacao(resultadoSolicitacao)
                .build();
    }
}
