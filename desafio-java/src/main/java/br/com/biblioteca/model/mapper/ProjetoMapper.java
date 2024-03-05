package br.com.biblioteca.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.biblioteca.generic.GenericMapper;
import br.com.biblioteca.model.dto.ProjetoDTO;
import br.com.biblioteca.model.entity.Projeto;

@Mapper //(imports = {TipoArquivoEnum.class})
public interface ProjetoMapper extends GenericMapper<Projeto, ProjetoDTO> {

    static final ProjetoMapper INSTANCE = Mappers.getMapper( ProjetoMapper.class );
    
}
