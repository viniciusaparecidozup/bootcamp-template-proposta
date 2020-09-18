package br.com.zup.bootcamp.dto.response;

import br.com.zup.bootcamp.dto.DTO;
import br.com.zup.bootcamp.dto.enums.ResultadoSolicitacao;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SolicitacaoAnaliseResponse extends DTO {

    private String idProposta;
    private String documento;
    private String nome;
    private ResultadoSolicitacao resultadoSolicitacao;

    public SolicitacaoAnaliseResponse() {
    }

}
