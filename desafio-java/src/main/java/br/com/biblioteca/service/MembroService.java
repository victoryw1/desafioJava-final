package br.com.biblioteca.service;

import org.springframework.stereotype.Service;

import br.com.biblioteca.generic.GenericRepository;
import br.com.biblioteca.model.entity.Membro;
import br.com.biblioteca.model.mapper.MembroMapper;
import br.com.biblioteca.repository.MembroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembroService extends AbstractMembroService {

    private final MembroRepository repository;

    @Override
    public GenericRepository<Membro> getRepository() {
        return repository;
    }

    @Override
    public MembroMapper getMapper() {
        return MembroMapper.INSTANCE;
    }
}
