package br.com.biblioteca.model.dto;

import javax.validation.constraints.NotNull;

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
public class MembroDTO {

    @NotNull
    private Long idProjeto;

    @NotNull
    private Long idPessoa;

    private PessoaDTO funcionario;
}
