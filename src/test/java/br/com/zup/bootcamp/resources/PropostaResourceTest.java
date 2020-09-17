package br.com.zup.bootcamp.resources;

import br.com.zup.bootcamp.dto.request.NovaPropostaRequest;
import br.com.zup.bootcamp.dto.response.NovaPropostaResponse;
import br.com.zup.bootcamp.service.PropostaService;
import br.com.zup.bootcamp.stub.PropostaStub;
import com.google.gson.Gson;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Log
class PropostaResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PropostaService propostaService;

    @Autowired
    private Gson gson;

    @Test
    void criarPropostaCpfTest() throws Exception {
        final NovaPropostaResponse response = PropostaStub.criaPropostaCpf(NovaPropostaResponse.class);
        when(propostaService.criarProposta(any(NovaPropostaRequest.class))).thenReturn(PropostaStub.criaPropostaCpf());
        final NovaPropostaRequest novaPropostaRequest = PropostaStub.criaPropostaCpf(NovaPropostaRequest.class);
        assertCriaPropostaComSucesso(response, novaPropostaRequest);
    }

    @Test
    void criarPropostaCnpjTest() throws Exception {
        final NovaPropostaResponse response = PropostaStub.criaPropostaCnpj(NovaPropostaResponse.class);
        when(propostaService.criarProposta(any(NovaPropostaRequest.class))).thenReturn(PropostaStub.criaPropostaCnpj());
        final NovaPropostaRequest novaPropostaRequest = PropostaStub.criaPropostaCnpj(NovaPropostaRequest.class);
        assertCriaPropostaComSucesso(response, novaPropostaRequest);
    }

    @Test
    void criarPropostaSemSucesso() throws Exception {
        final NovaPropostaRequest novaPropostaRequest = PropostaStub.criaPropostaCnpj(NovaPropostaRequest.class);
        novaPropostaRequest.setDocumento(null);
        mockMvc.perform(post(Routes.CRIAR_PROPOSTA)
                .content(gson.toJson(novaPropostaRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    private void assertCriaPropostaComSucesso(NovaPropostaResponse response, NovaPropostaRequest novaPropostaRequest) throws Exception {
        mockMvc.perform(post(Routes.CRIAR_PROPOSTA)
                .content(gson.toJson(novaPropostaRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.nome").exists())
                .andExpect(jsonPath("$.endereco").exists())
                .andExpect(jsonPath("$.salario").exists())
                .andExpect(jsonPath("$.email").value(response.getEmail()))
                .andExpect(jsonPath("$.nome").value(response.getNome()))
                .andExpect(jsonPath("$.endereco").value(response.getEndereco()))
                .andExpect(jsonPath("$.salario").value(response.getSalario()))
                .andExpect(status().isCreated());
    }

}