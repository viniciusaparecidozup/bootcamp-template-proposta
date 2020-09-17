package br.com.zup.bootcamp.stub;

import br.com.zup.bootcamp.dto.DTO;
import br.com.zup.bootcamp.dto.request.NovaPropostaRequest;
import br.com.zup.bootcamp.dto.response.NovaPropostaResponse;
import br.com.zup.bootcamp.model.Proposta;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

public class PropostaStub {


    public static <T extends DTO> T criaPropostaCpf(Class<T> classType) {
        if (classType.equals(NovaPropostaRequest.class)) {
            final NovaPropostaRequest novaPropostaRequest = new NovaPropostaRequest();
            BeanUtils.copyProperties(criaPropostaCpf(), novaPropostaRequest);
            return (T) novaPropostaRequest;
        }
        final NovaPropostaResponse novaPropostaResponse = new NovaPropostaResponse();
        BeanUtils.copyProperties(PropostaStub.criaPropostaCpf(), novaPropostaResponse);
        return (T) novaPropostaResponse;
    }

    public static <T extends DTO> T criaPropostaCnpj(Class<T> classType) {
        if (classType.equals(NovaPropostaRequest.class)) {
            final NovaPropostaRequest novaPropostaRequest = new NovaPropostaRequest();
            BeanUtils.copyProperties(criaPropostaCnpj(), novaPropostaRequest);
            return (T) novaPropostaRequest;
        }
        final NovaPropostaResponse novaPropostaResponse = new NovaPropostaResponse();
        BeanUtils.copyProperties(PropostaStub.criaPropostaCnpj(), novaPropostaResponse);
        return (T) novaPropostaResponse;
    }

    public static Proposta criaPropostaCpf() {
        final Proposta proposta = new Proposta("propostacpf@proposta.com.br",
                "Proposta Cpf Mock",
                "Rua da Proposta do CPF",
                BigDecimal.ONE,
                "338.303.080-60");
        proposta.setId(1L);

        return proposta;
    }

    public static Proposta criaPropostaCnpj() {
        final Proposta proposta = new Proposta("propostacnpj@proposta.com.br",
                "Proposta cnpj Mock",
                "Rua da Proposta do cnpj",
                BigDecimal.ONE,
                "31.875.254/0001-87");
        proposta.setId(2l);
        return proposta;
    }
}
