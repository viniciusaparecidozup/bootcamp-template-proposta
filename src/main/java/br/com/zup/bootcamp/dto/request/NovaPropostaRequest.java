package br.com.zup.bootcamp.dto.request;

import br.com.zup.bootcamp.dto.DTO;
import br.com.zup.bootcamp.model.Proposta;
import br.com.zup.bootcamp.validator.CpfCnpj;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
public class NovaPropostaRequest extends DTO {

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

    public NovaPropostaRequest(@Email @NotBlank String email,
                               @NotBlank String nome, @NotBlank String endereco,
                               @Positive BigDecimal salario, String documento) {
        super();
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.documento = documento;
    }

    public NovaPropostaRequest() {

    }

    public Proposta toModel() {
        return new Proposta(email, nome, endereco, salario, documento);
    }

}