package br.com.crud.model.pessoa;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PessoaDTO {

    private Long id;
    private String nome;

}
