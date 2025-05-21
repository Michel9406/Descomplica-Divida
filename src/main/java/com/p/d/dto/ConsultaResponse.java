package com.p.d.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ConsultaResponse {

    private String descricao;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private boolean paga;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public boolean isPaga() {
		return paga;
	}
	public void setPaga(boolean paga) {
		this.paga = paga;
	}

    // Construtor, Getters e Setters
}