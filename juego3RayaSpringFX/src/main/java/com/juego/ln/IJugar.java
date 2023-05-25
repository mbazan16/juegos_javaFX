package com.juego.ln;

import com.juego.data.Jugador;
import com.juego.data.Partida;
import com.juego.data.Posicion;

public interface IJugar {
	
	public void iniciarPartida(Partida partida);
	
	public void colocarFicha(Posicion posicion, Jugador jugador);

	public Posicion colocarFichaAutomatico(Jugador jugador);
	

}
