package br.com.biblioteca.service;

import org.springframework.stereotype.Service;

import br.com.biblioteca.generic.GenericMapper;
import br.com.biblioteca.generic.GenericRepository;
import br.com.biblioteca.generic.GenericService;
import br.com.biblioteca.model.dto.ProjetoDTO;
import br.com.biblioteca.model.entity.Projeto;
import br.com.biblioteca.model.mapper.ProjetoMapper;
import br.com.biblioteca.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoService extends GenericService<Projeto, ProjetoDTO> {

    private final ProjetoRepository repository;

    @Override
    public GenericRepository<Projeto> getRepository() {
        return repository;
    }

    @Override
    public GenericMapper<Projeto, ProjetoDTO> getMapper() {
        return ProjetoMapper.INSTANCE;
    }
    
}
