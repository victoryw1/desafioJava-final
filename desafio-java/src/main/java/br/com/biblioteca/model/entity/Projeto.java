package br.com.biblioteca.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
import br.com.biblioteca.generic.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name = "projeto", schema = "public")
public class Projeto extends GenericEntity {
    
    @NotNull
    @Size(max = 200)
    @Column(nullable=false)
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_previsao_fim")
    private LocalDate dataPrevisaoFim;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "orcamento")
    private Float orcamentoTotal;

    @Enumerated(EnumType.STRING)
    private RiscoEnum risco;
    
    @Column(name = "idgerente", nullable=false)
    private Long idGerente;

    @ManyToOne
	@JoinColumn(name = "idgerente", insertable = false, updatable = false )
	private Pessoa gerente;
}
