package br.com.bycoders.util;

import lombok.Getter;

@Getter
public enum CnabSeparator {
	
	TIPO(0,1),
	DATA(1,9),
	VALOR(9,19),
	CPF(19,30),
	CARTAO(30,42),
	HORA(42,48),
	DONO(48,62),
	LOJA(62,80);
	
	private int begin;
	private int end;
	
	CnabSeparator(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
}
