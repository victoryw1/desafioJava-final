package br.com.biblioteca.generic;

import org.springframework.data.domain.Page;

import java.util.List;

public interface GenericMapper <E extends GenericEntity, D extends GenericDTO> {

    D parseEntityToDTO(E entity);
	
	E parseDTOToEntity(D dto);

    List<D> listEntityToListDTO(List<E> list);

	List<E> listDTOToListEntity(List<D> list);
	
    default Page<D> pageEntityToPageDTO(Page<E> pageEntity) {
		return pageEntity.map(this::parseEntityToDTO);
	}
}
