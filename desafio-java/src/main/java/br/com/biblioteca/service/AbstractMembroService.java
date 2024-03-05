package br.com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.transaction.annotation.Transactional;

import br.com.biblioteca.generic.GenericRepository;
import br.com.biblioteca.model.mapper.MembroMapperDefault;

public abstract class AbstractMembroService <E, DTO> {

    public abstract GenericRepository<E> getRepository();
    public abstract MembroMapperDefault<E, DTO> getMapper();

    @SuppressWarnings("null")
    @Transactional
	public E adicionar(DTO dto) {

		var entity = getMapper().parseDTOToEntity(dto);
		
		return getRepository().save(entity);
	}

    @Transactional(readOnly = true)
	public E findById(Long id){
    	@SuppressWarnings("null")
        Optional<E> optional = getRepository().findById(id);
		return (optional.isPresent()) ? optional.get() : null;
	}

    @Transactional(readOnly = true)
    public List<E> findAll() {
        return getRepository().findAll();
    }

    @SuppressWarnings("null")
    @Transactional(readOnly = true)
	public List<DTO> listar(DTO dto) {
        E entity = getMapper().parseDTOToEntity(dto);
        return getMapper().listEntityToListDTO(getRepository().findAll(
                Example.of(entity,
                        ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase()
                                .withStringMatcher(StringMatcher.EXACT))));
    }
}
