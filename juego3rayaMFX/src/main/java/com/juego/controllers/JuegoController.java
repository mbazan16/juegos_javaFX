package com.juego.controllers;

import java.io.IOException;

import com.juego.Juego3RayaJFX;
import com.juego.data.Partida;
import com.juego.data.Posicion;
import com.juego.data.TipoResultado;
import com.juego.exceptions.EmpateException;
import com.juego.exceptions.GanadorException;
import com.juego.exceptions.PerdedorException;
import com.juego.ln.IJugar;
import com.juego.ln.Jugar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JuegoController extends PadreController {

	@FXML
	private Label resultado;
	
	@FXML
	private GridPane tablero;
	
	@FXML
	private Button bSeguir;
	
	@FXML
	private Button bSalir;

	IJugar jugar;

	Partida partida;

	public JuegoController() {
		super();
		this.jugar = new Jugar();

	}

	@FXML
	private void handleButtonClick(ActionEvent event) throws IOException {
		System.out.println("hola el boton se ha pulsado");
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		System.out.println("Partida:" + partida);
		if (this.partida == null) {
			this.partida = (Partida) stage.getUserData();
			this.jugar.iniciarPartida(this.partida);
		}
		System.out.println("Partida:" + partida);
		Button boton = (Button) event.getSource();
		String coordenadas = boton.getId().substring(1);
		try {
			boton.setText(this.partida.getJugador1().getFicha().getSimbolo());
			boton.setDisable(true);
			Posicion posicionAutomatica = jugar(coordenadas);
			String idButton = "#b" + posicionAutomatica.getFila() + posicionAutomatica.getColumna();
			System.out.println("Idbutton:" + idButton);
			Scene scene = stage.getScene();

			Button celdaElegidaOrdenador = (Button) scene.lookup(idButton);
			System.out.println("Button:" + celdaElegidaOrdenador);
			celdaElegidaOrdenador.setText(this.partida.getJugador2().getFicha().getSimbolo());
			celdaElegidaOrdenador.setDisable(true);

		} catch (EmpateException ee) {
			mostrarResultado(TipoResultado.EMPATE);			
		} catch (PerdedorException pe) {
			mostrarResultado(TipoResultado.PERDEDOR);			
		} catch (GanadorException ee) {
			mostrarResultado(TipoResultado.GANADOR);			
		}

	}

	private Posicion jugar(String coordenadas) {
		int fila = Integer.valueOf(coordenadas.substring(0, 1));
		int columna = Integer.valueOf(coordenadas.substring(1));
		Posicion posicion = new Posicion(fila, columna);

		this.jugar.colocarFicha(posicion, this.partida.getJugador1());

		Posicion posicionAutomatica = this.jugar.colocarFichaAutomatico(this.partida.getJugador2());
		return posicionAutomatica;
	}
	
	
	private void mostrarResultado(TipoResultado tipoResultado) {
		resultado.setText(tipoResultado.getMensaje());
		resultado.setVisible(true);
		bSeguir.setVisible(true);
		bSalir.setVisible(true);
		tablero.setDisable(true);
	}

	@FXML
	private void handleButtonSalirClick(ActionEvent event) throws IOException {
		System.out.println("Salimos");
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();

		Scene scene = Juego3RayaJFX.loadView("inicio", "application");
		stage.setTitle("Juego3Raya JavaFX");
		stage.setScene(scene);
		stage.show();
		
	}
	
	@FXML
	private void handleButtonSeguirClick(ActionEvent event) throws IOException {
		System.out.println("Seguimos");
		resultado.setText("");
		resultado.setVisible(false);
		bSeguir.setVisible(false);
		bSalir.setVisible(false);
		this.partida=null;
		tablero.setDisable(false);
	    tablero.getChildren().forEach(s -> ((Button)s).setText(""));
	    tablero.getChildren().forEach(s -> ((Button)s).setDisable(false));
		
		
	}

}
