package com.juego.data;

public class Celda {
	
	private Ficha ficha;
	private final Posicion posicion;		

	public Celda(int fila, int columna) {
		super();
		this.posicion = new Posicion(fila,columna);
	}

	public Celda(Ficha ficha, Posicion posicion) {
		super();
		this.ficha = ficha;
		this.posicion = posicion;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void mostrarCelda() {
		
		if(ficha!=null) System.out.print("| "+ficha.getSimbolo()+" |");
		if(ficha==null) System.out.print("|   |");
		
		
	}

	
	
	
	

}
