package br.com.biblioteca.generic;

import org.springframework.data.domain.Page;

import java.util.List;

public interface GenericMapper <E extends GenericEntity, DTO extends GenericDTO> {

    DTO parseEntityToDTO(E entity);
	
	E parseDTOToEntity(DTO dto);

    List<DTO> listEntityToListDTO(List<E> list);

	List<E> listDTOToListEntity(List<DTO> list);
	
    default Page<DTO> pageEntityToPageDTO(Page<E> pageEntity) {
		return pageEntity.map(this::parseEntityToDTO);
	}
}
