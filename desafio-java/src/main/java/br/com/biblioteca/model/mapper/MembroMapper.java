package br.com.biblioteca.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.biblioteca.model.dto.MembroDTO;
import br.com.biblioteca.model.entity.Membro;

@Mapper
public interface MembroMapper extends MembroMapperDefault<Membro, MembroDTO> {

    static final MembroMapper INSTANCE = Mappers.getMapper( MembroMapper.class );

}
