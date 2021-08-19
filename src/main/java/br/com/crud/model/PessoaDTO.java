package br.com.crud.model;

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
