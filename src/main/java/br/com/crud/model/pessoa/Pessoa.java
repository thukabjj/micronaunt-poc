package br.com.crud.model.pessoa;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.persistence.*;

@Entity
@Introspected
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

}
