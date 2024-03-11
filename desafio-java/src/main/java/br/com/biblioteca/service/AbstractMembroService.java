package br.com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.transaction.annotation.Transactional;

import br.com.biblioteca.generic.GenericRepository;
import br.com.biblioteca.model.dto.MembroDTO;
import br.com.biblioteca.model.entity.Membro;
import br.com.biblioteca.model.mapper.MembroMapper;

public abstract class AbstractMembroService {

    public abstract GenericRepository<Membro> getRepository();
    public abstract MembroMapper getMapper();

    @SuppressWarnings("null")
    @Transactional
	public Membro adicionar(MembroDTO dto) {

		var entity = getMapper().parseDTOToEntity(dto);
		
		return getRepository().save(entity);
	}

    @Transactional(readOnly = true)
	public Membro findById(Long id){
    	@SuppressWarnings("null")
        Optional<Membro> optional = getRepository().findById(id);
		return (optional.isPresent()) ? optional.get() : null;
	}

    @Transactional(readOnly = true)
    public List<Membro> findAll() {
        return getRepository().findAll();
    }

    @SuppressWarnings("null")
    @Transactional(readOnly = true)
	public List<MembroDTO> listar(MembroDTO dto) {
        Membro entity = getMapper().parseDTOToEntity(dto);
        return getMapper().listEntityToListDTO(getRepository().findAll(
                Example.of(entity,
                        ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase()
                                .withStringMatcher(StringMatcher.EXACT))));
    }
}
