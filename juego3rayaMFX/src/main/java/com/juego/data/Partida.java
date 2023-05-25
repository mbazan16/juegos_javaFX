package com.juego.data;

public class Partida {
	
	Jugador jugador1;
	Jugador jugador2;
	
	int numTurnos;
	int resultado;
	

	public Partida(Jugador jugador1, Jugador jugador2) {
		this.jugador1=jugador1;
		this.jugador2=jugador2;
	}


	public Jugador getJugador1() {
		return jugador1;
	}


	

	public Jugador getJugador2() {
		return jugador2;
	}


	


	public int getNumTurnos() {
		return numTurnos;
	}


	public void setNumTurnos(int numTurnos) {
		this.numTurnos = numTurnos;
	}


	public int getResultado() {
		return resultado;
	}


	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	

}
