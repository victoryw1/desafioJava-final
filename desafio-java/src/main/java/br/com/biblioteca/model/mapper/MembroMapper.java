package br.com.biblioteca.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import br.com.biblioteca.model.dto.MembroDTO;
import br.com.biblioteca.model.entity.Membro;

@Mapper
public interface MembroMapper {

    static final MembroMapper INSTANCE = Mappers.getMapper( MembroMapper.class );

    MembroDTO parseEntityToDTO(Membro membro);
	
	Membro parseDTOToEntity(MembroDTO dto);

    List<MembroDTO> listEntityToListDTO(List<Membro> list);

	List<Membro> listDTOToListEntity(List<MembroDTO> list);

    default Page<MembroDTO> pageEntityToPageDTO(Page<Membro> pageEntity) {
		return pageEntity.map(this::parseEntityToDTO);
	}

}
