package br.com.zup.bootcamp.proposta.model;

import br.com.zup.bootcamp.proposta.response.NovaPropostaResponse;
import br.com.zup.bootcamp.proposta.validator.CpfCnpj;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @Email @NotBlank String email;
    private @NotBlank String nome;
    private @NotBlank String endereco;
    private @Positive BigDecimal salario;
    @CpfCnpj
    @NotBlank
    private String documento;

    public Proposta(@Email @NotBlank String email, @NotBlank String nome,
                    @NotBlank String endereco, @Positive BigDecimal salario,
                    @CpfCnpj String documento) {
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.documento = documento;
    }

    public Long getId() {
        Objects.requireNonNull(id, "O objeto precisa estar salvo para invocar o getId");
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

}