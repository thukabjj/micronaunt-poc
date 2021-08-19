package br.com.crud.model.pessoa;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PessoaMapper {
    public static final PessoaMapper INSTANCE = Mappers.getMapper( PessoaMapper.class );
    PessoaDTO toPessoaDTO(Pessoa pessoa);
    Pessoa toPessoa(PessoaDTO pessoaDTO);

    List<PessoaDTO> toPessoaDTOList(List<Pessoa> pessoas);
    List<Pessoa> toPessoaList(List<PessoaDTO> pessoasDTO);
}
