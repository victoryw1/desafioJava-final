package br.com.biblioteca.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.biblioteca.generic.GenericMapper;
import br.com.biblioteca.model.dto.PessoaDTO;
import br.com.biblioteca.model.entity.Pessoa;

@Mapper //(imports = {TipoArquivoEnum.class})
public interface PessoaMapper extends GenericMapper<Pessoa, PessoaDTO> {

    static final PessoaMapper INSTANCE = Mappers.getMapper( PessoaMapper.class );
    
}
