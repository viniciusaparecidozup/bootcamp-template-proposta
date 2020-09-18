package br.com.zup.bootcamp.dto.request;

import br.com.zup.bootcamp.dto.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitacaoAnaliseRequest extends DTO {

    private String documento;
    private String nome;

    public SolicitacaoAnaliseRequest() {
    }

    public SolicitacaoAnaliseRequest(String documento) {
        this.documento = documento;
    }
}
