package com.juego.data;

public abstract class Ficha {
	
	private int valor;
	private String simbolo;
	
	public Ficha(int valor) {
		super();
		this.valor = valor;
		this.simbolo=" X ";
	}
	public Ficha(int valor, String simbolo) {
		super();
		this.valor = valor;
		this.simbolo = simbolo;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	
	

}
