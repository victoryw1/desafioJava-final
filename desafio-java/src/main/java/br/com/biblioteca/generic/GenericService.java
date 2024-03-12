package br.com.biblioteca.generic;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericService <E extends GenericEntity, D extends GenericDTO> {

    public abstract GenericRepository<E> getRepository();
    public abstract GenericMapper<E, D> getMapper();
    
    @SuppressWarnings("null")
    @Transactional
	public E adicionar(D dto) {

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
	public List<D> listar(D dto) {
        E entity = getMapper().parseDTOToEntity(dto);
        return getMapper().listEntityToListDTO(getRepository().findAll(
                Example.of(entity,
                        ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase()
                                .withStringMatcher(StringMatcher.EXACT))));
    }

    @SuppressWarnings("null")
    @Transactional
	public void delete(Long codigo) {
		getRepository().deleteById(codigo); 
	}
}
