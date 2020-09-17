package br.com.zup.bootcamp.repository;

import br.com.zup.bootcamp.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, String> {

    Optional<Proposta> findByDocumento(String documento);

}
