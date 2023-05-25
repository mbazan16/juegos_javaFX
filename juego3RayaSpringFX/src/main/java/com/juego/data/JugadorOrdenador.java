package com.juego.data;

public class JugadorOrdenador extends Jugador {

	public JugadorOrdenador(String nombre) {
		super(nombre);
		
	}

	@Override
	public Ficha getFicha() {
		FichaNegra ficha = new FichaNegra();
		this.fichas.add(ficha);
		return ficha;
	}

}
