package br.com.zup.bootcamp.dto.enums;

import lombok.Getter;

public enum ResultadoSolicitacao {

    SEM_RESTRICAO("ELEGIVEL"),
    COM_RESTRICAO("NAO_ELEGIVEL");

    @Getter
    private final String status;

    ResultadoSolicitacao(String status) {
        this.status = status;
    }
}
