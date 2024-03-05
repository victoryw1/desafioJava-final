package br.com.biblioteca.repository;

import java.util.List;

import br.com.biblioteca.generic.GenericRepository;
import br.com.biblioteca.model.entity.Pessoa;

public interface PessoaRepository extends GenericRepository<Pessoa>{

    List<Pessoa> findAllByFuncionarioIsTrue();
    List<Pessoa> findAllByGerenteIsTrue();
}
