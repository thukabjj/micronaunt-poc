package br.com.crud.model.user;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Introspected
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User {

    @Id
    private String username;

    @Column
    @Size(min = 6)
    private String password;
}
