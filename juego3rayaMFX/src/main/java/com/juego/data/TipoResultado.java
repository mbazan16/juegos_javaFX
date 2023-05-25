package com.juego.data;

public enum TipoResultado {GANADOR("¡¡¡FELICIDADES HAS GANADO!!!"),
						   PERDEDOR("LO SENTIMOS HAS PERDIDO"),
						   EMPATE("SE HA PRODUCIDO EMPATE");
	
	private String mensaje;

	private TipoResultado(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return this.mensaje;
	}

}
