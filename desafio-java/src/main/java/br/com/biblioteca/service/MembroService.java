package br.com.biblioteca.service;

import org.springframework.stereotype.Service;

import br.com.biblioteca.generic.GenericRepository;
import br.com.biblioteca.model.dto.MembroDTO;
import br.com.biblioteca.model.entity.Membro;
import br.com.biblioteca.model.mapper.MembroMapperDefault;
import br.com.biblioteca.model.mapper.MembroMapper;
import br.com.biblioteca.repository.MembroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembroService extends AbstractMembroService<Membro, MembroDTO> {

    private final MembroRepository repository;

    @Override
    public GenericRepository<Membro> getRepository() {
        return repository;
    }

    public MembroMapperDefault<Membro, MembroDTO> getMapper() {
        return MembroMapper.INSTANCE;
    }
}
