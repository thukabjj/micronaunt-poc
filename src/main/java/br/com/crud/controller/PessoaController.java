package br.com.crud.controller;

import br.com.crud.model.pessoa.Pessoa;
import br.com.crud.model.pessoa.PessoaDTO;
import br.com.crud.model.pessoa.PessoaMapper;
import br.com.crud.repository.PessoaRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/pessoas")
public class PessoaController {

    @Inject
    private PessoaRepository pessoaRepository;

    
    @Get
    public HttpResponse<List<PessoaDTO>> getPessoas(){
        final List<Pessoa> pessoasEntities = pessoaRepository.findAll();
        return HttpResponse.ok(PessoaMapper.INSTANCE.toPessoaDTOList(pessoasEntities));
    }

    @Post
    public HttpResponse<PessoaDTO> addPessoa(PessoaDTO pessoaDTO) {
        final Pessoa pessoa = PessoaMapper.INSTANCE.toPessoa(pessoaDTO);
        final Pessoa pessoaEntity = pessoaRepository.save(pessoa);
        return HttpResponse.ok(PessoaMapper.INSTANCE.toPessoaDTO(pessoaEntity));
    }
}
