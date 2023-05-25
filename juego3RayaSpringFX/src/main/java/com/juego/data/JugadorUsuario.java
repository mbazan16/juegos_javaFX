package com.juego.data;

public class JugadorUsuario extends Jugador {

	public JugadorUsuario(String nombre) {
		super(nombre);

	}

	public Ficha getFicha() {
		FichaBlanca ficha = new FichaBlanca();
		this.fichas.add(ficha);
		return ficha;
	}

}
