package com.juego.data;

/**
 * EJEMPLO DE SINGLETON:
 *  -- Variable privada estática de la instancia
 *  -- Constructor privado
 *  -- Método público estático que devuelve la instancia
 * 
 */
public class Tablero {
	
	private static Tablero instancia;

	private Celda[][] tablero;

	private Tablero(int filas, int columnas) {
		super();
		this.tablero = new Celda[filas][columnas];
	}
	
	/**
	 * Devuelve una instancia de Tablero, va a ser única en todo el Juego,
	 * se realiza mediante el patrón Singleton.
	 * El tablero se inicializa según filas y columnas pasadas por parámetro.
	 * @param filas
	 * @param columnas
	 * @return
	 */
	public static Tablero inicializar(int filas, int columnas) {
		if(instancia == null) instancia = new Tablero(filas, columnas);
		for (int fila = 0; fila < filas; fila++) {
			for (int columna = 0; columna < columnas; columna++) {
				instancia.tablero[fila][columna] = new Celda(fila, columna);
			}
		}
		return instancia;
	}

	public Celda[][] getTablero() {
		return tablero;
	}

	public void setTablero(Celda[][] tablero) {
		this.tablero = tablero;
	}

	

}
