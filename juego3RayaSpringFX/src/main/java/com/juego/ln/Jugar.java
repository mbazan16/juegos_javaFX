package com.juego.ln;

import com.juego.common.Constantes;
import com.juego.data.Celda;
import com.juego.data.Ficha;
import com.juego.data.Jugador;
import com.juego.data.JugadorUsuario;
import com.juego.data.Partida;
import com.juego.data.Posicion;
import com.juego.data.Tablero;
import com.juego.exceptions.EmpateException;
import com.juego.exceptions.GanadorException;
import com.juego.exceptions.PerdedorException;

public class Jugar implements IJugar {
	
	Celda[][] tablero;
	Partida partida;
	
	
	


	public void iniciarPartida(Partida partida) {
		this.partida=partida;
		this.tablero=Tablero.inicializar(Constantes.NUM_FILAS_TABLERO, Constantes.NUM_COLUMNAS_TABLERO).getTablero();
		
	}

	

	/**
	 * Se coloca en el tablero una ficha. 
	 * A la celda correspondiente por la posicion se la asigna la ficha
	 */
	public void colocarFicha(Posicion posicion, Jugador jugador) {
		if(isLLeno()) throw new EmpateException();
		Celda celda = tablero[posicion.getFila()][posicion.getColumna()];
		celda.setFicha(jugador.getFicha());
		if(comprobarGanador(jugador.getValorFicha())) {
			
			if(jugador instanceof JugadorUsuario) {
				throw new GanadorException(jugador.getNombre());
			}else {
				throw new PerdedorException();
			}
		}
		
		
	}
	
	/**
	 * Se coloca en el tablero una ficha. 
	 * A la celda correspondiente por la posicion se la asigna la ficha
	 */
	public Posicion colocarFichaAutomatico(Jugador jugador) {
		if(isLLeno()) throw new EmpateException();
		Posicion posicion = elegirPosicion();
		Celda celda = tablero[posicion.getFila()][posicion.getColumna()];
		celda.setFicha(jugador.getFicha());
		if(comprobarGanador(jugador.getValorFicha())) {
			
			if(jugador instanceof JugadorUsuario) {
				throw new GanadorException(jugador.getNombre());
			}else {
				throw new PerdedorException();
			}
		}
		return posicion;
	}

	/**
	 * Se comprueba si alguna fila, columna o diagonal, tiene suma de valores,
	 * el valor de la ficha por 3, eso significaria que hay tres fichas alineadas
	 * @param valorFicha
	 * @return si existe ganador
	 */
	private boolean comprobarGanador(int valorFicha) {
		int valorGanador = valorFicha * 3;
		int suma = 0;
		// Repasamos filas
		for (int fila = 0; fila < tablero.length; fila++) {
			if(tablero[fila][0].getFicha()!=null) suma += tablero[fila][0].getFicha().getValor();
			if(tablero[fila][1].getFicha()!=null) suma += tablero[fila][1].getFicha().getValor();
			if(tablero[fila][2].getFicha()!=null) suma += tablero[fila][2].getFicha().getValor();
			if (suma == valorGanador)
				return Boolean.TRUE;
			suma = 0;
		}
		// Repasamos columnas
		for (int columna = 0; columna < tablero[0].length; columna++) {
			if(tablero[0][columna].getFicha()!=null) suma += tablero[0][columna].getFicha().getValor();
			if(tablero[1][columna].getFicha()!=null) suma += tablero[1][columna].getFicha().getValor();
			if(tablero[2][columna].getFicha()!=null) suma += tablero[2][columna].getFicha().getValor();
			if (suma == valorGanador)
				return Boolean.TRUE;
			suma = 0;
		}
		if(tablero[0][0].getFicha()!=null) suma += tablero[0][0].getFicha().getValor();
		if(tablero[1][1].getFicha()!=null) suma += tablero[1][1].getFicha().getValor();
		if(tablero[2][2].getFicha()!=null) suma += tablero[2][2].getFicha().getValor();
		if (suma == valorGanador)
			return Boolean.TRUE;
		suma = 0;
		
		if(tablero[0][2].getFicha()!=null) suma += tablero[0][2].getFicha().getValor();
		if(tablero[1][1].getFicha()!=null) suma += tablero[1][1].getFicha().getValor();
		if(tablero[2][0].getFicha()!=null) suma += tablero[2][0].getFicha().getValor();
		if (suma == valorGanador)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	/**
	 * Se comprueba si existen celdas vacías dentro del tablero
	 * @return boolean - TRUE si esta lleno
	 */
	private boolean isLLeno() {
		
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[fila].length; columna++) {
				if (tablero[fila][columna].getFicha() == null)
					return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}



	/**
	 * Se elige una Posición (la primera libre)
	 */
	private Posicion elegirPosicion() {
		
		for (int fila = 0; fila < this.tablero.length; fila++) {
			for (int columna = 0; columna < this.tablero[fila].length; columna++) {
				if (this.tablero[fila][columna].getFicha() == null)
					return this.tablero[fila][columna].getPosicion();
			}
		}
		return null;
	}

}
