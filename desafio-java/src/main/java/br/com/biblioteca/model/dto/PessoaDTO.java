package br.com.biblioteca.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.biblioteca.generic.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class PessoaDTO extends GenericDTO {
    
    @NotBlank
    private String nome;

    private LocalDate dataNascimento;

    private String cpf;

    @NotNull
    private Boolean funcionario;

    private Boolean gerente;
}
