package br.com.biblioteca.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

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
@Table(name = "pessoa", schema = "public")
public class Pessoa extends GenericEntity {
    
    @NotNull
    @Size(max = 100)
    @Column(nullable=false)
    private String nome;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    @CPF
    private String cpf;

    private Boolean funcionario;

    private Boolean gerente;
}
