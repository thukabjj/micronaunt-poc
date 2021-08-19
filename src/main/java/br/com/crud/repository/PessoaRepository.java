package br.com.crud.repository;

import br.com.crud.model.pessoa.Pessoa;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
