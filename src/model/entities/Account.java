package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
	
	public Account() {
	}

	public Account(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}
	
	public void deposito(double quantidade) throws DomainException{
		this.saldo += quantidade;
	}
	
	public void saque(double quantidade) throws DomainException{
		if (quantidade > limiteSaque) {
			throw new DomainException("A quantidade de saque excede o limite permitido!");
		} else if (quantidade > saldo) {
			throw new DomainException("Saldo insuficiente!");
		} else {
			this.saldo -= quantidade;
		}
	}
}
