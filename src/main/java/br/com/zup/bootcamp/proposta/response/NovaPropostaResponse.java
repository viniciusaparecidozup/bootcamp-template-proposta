package br.com.zup.bootcamp.proposta.response;

import br.com.zup.bootcamp.proposta.model.Proposta;
import br.com.zup.bootcamp.proposta.validator.CpfCnpj;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovaPropostaResponse {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotNull
    @Positive
    private BigDecimal salario;
    @CpfCnpj
    @NotBlank
    private String documento;

    public NovaPropostaResponse(@Email @NotBlank String email,
                                @NotBlank String nome, @NotBlank String endereco,
                                @Positive BigDecimal salario, String documento) {
        super();
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.documento = documento;
    }

    public static NovaPropostaResponse toResponse(Proposta proposta){
        return new NovaPropostaResponse(proposta.getEmail(),
                proposta.getNome(),
                proposta.getEndereco(),
                proposta.getSalario(),
                proposta.getDocumento());
    }
}