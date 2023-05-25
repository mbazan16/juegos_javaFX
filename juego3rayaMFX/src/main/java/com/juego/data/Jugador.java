package com.juego.data;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {	
	
	private String nombre;
	
	protected List<Ficha> fichas = new ArrayList<Ficha>();

	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}
	
	public abstract Ficha getFicha();
	
	public int getValorFicha() {
		return fichas.get(0).getValor();
	}
	
	
	

}
