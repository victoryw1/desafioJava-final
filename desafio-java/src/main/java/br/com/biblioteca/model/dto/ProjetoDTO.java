package br.com.biblioteca.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
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
public class ProjetoDTO extends GenericDTO {

    @NotEmpty
    private String nome;
   
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataInicio;

    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataPrevisaoFim;

    @DateTimeFormat(iso = ISO.DATE)
    // @FutureOrPresent
    private LocalDate dataFim;

    private String descricao;

    private StatusEnum status;

    private Float orcamentoTotal;

    private RiscoEnum risco;
    
    @NotNull
    private Long idGerente;

    private PessoaDTO gerente;
    
}
