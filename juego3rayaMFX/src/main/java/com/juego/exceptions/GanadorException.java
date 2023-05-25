package com.juego.exceptions;

public class GanadorException extends RuntimeException {
	
	private final String nombreGanador;

	public GanadorException(String nombreGanador) {
		super();
		this.nombreGanador=nombreGanador;
	}

	public String getNombreGanador() {
		return nombreGanador;
	}

	
	
	

}
