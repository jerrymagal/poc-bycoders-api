package br.com.bycoders.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name="tipo_transacao")
public class TipoTransacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	private Integer codigo;

	public TipoTransacao(Integer codigo) {
		this.codigo = codigo;
	}

	@Column
	private String descricao;
	
	@Column
	private String natureza;
	
	@Column
	private String sinal;
}
