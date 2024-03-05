package br.com.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.biblioteca.generic.GenericMapper;
import br.com.biblioteca.generic.GenericRepository;
import br.com.biblioteca.generic.GenericService;
import br.com.biblioteca.model.dto.PessoaDTO;
import br.com.biblioteca.model.entity.Pessoa;
import br.com.biblioteca.model.mapper.PessoaMapper;
import br.com.biblioteca.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService extends GenericService<Pessoa, PessoaDTO> {
 
    private final PessoaRepository repository;

    @Override
    public GenericRepository<Pessoa> getRepository() {
        return repository;
    }

    @Override
    public GenericMapper<Pessoa, PessoaDTO> getMapper() {
        return PessoaMapper.INSTANCE;
    }

    @Transactional(readOnly = true)
    public List<PessoaDTO> listarFuncionarios() {
        return getMapper().listEntityToListDTO(repository.findAllByFuncionarioIsTrue());
    }

    @Transactional(readOnly = true)
    public List<PessoaDTO> listarGerentes() {
        return getMapper().listEntityToListDTO(repository.findAllByGerenteIsTrue());
    }
}
