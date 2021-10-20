package br.com.bycoders.entities;

import static br.com.bycoders.util.CnabSeparator.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.bycoders.util.ConverterUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cnab implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	@Column
	private BigDecimal valor;
	
	@Column
	private String cpf;
	
	@Column
	private String cartao;
	
	@Column
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime hora;
	
	@Column
	private String dono;
	
	@Column
	private String loja;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="tipo_transacao")
	private TipoTransacao tipoTransacao;
	
	public static Cnab build(String registro) {
		
		return Cnab.builder()
						.data(ConverterUtils.convertToLocalDate(registro.substring(DATA.getBegin(), DATA.getEnd())))
						.valor(new BigDecimal(registro.substring(VALOR.getBegin(), VALOR.getEnd())))
						.cpf(registro.substring(CPF.getBegin(), CPF.getEnd()))
						.cartao(registro.substring(CARTAO.getBegin(), CARTAO.getEnd()))
						.hora(ConverterUtils.convertToLocalTime(registro.substring(HORA.getBegin(), HORA.getEnd())))
						.dono(registro.substring(DONO.getBegin(), DONO.getEnd()))
						.loja(registro.substring(LOJA.getBegin(), LOJA.getEnd()))
						.tipoTransacao(new TipoTransacao(Integer.valueOf(registro.substring(TIPO.getBegin(), TIPO.getEnd()))))
					.build();
	}
}
