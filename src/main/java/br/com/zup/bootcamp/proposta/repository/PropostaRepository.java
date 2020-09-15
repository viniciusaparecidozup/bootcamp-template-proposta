package br.com.zup.bootcamp.proposta.repository;

import java.util.Optional;

import br.com.zup.bootcamp.proposta.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, String> {

    Optional<Proposta> findByDocument(String document);
}
