package br.com.biblioteca.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "membros", schema = "public")
public class Membro implements Serializable {

    @Id
    @Column(name = "idprojeto", nullable=false)
    private Long idProjeto;

    @Column(name = "idpessoa", nullable=false)
    private Long idPessoa;

    @ManyToOne
	@JoinColumn(name = "idpessoa", insertable = false, updatable = false )
	private Pessoa funcionario;
}
