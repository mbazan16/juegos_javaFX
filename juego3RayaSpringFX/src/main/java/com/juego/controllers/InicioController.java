package com.juego.controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.juego.Juego3RayaSpringFxApplication;
import com.juego.data.JugadorOrdenador;
import com.juego.data.JugadorUsuario;
import com.juego.data.Partida;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class InicioController extends PadreController{
	
	@FXML
    private Button bNombreJugador;
	
	@FXML
    private TextField nombreJugador;
	
	

    @FXML
    private void handleButtonClick(ActionEvent event) throws IOException{
    	iniciarPartida(event);		
    	mostrarPantallaPartida(event);
    }


    

	private void iniciarPartida(ActionEvent event) {
		JugadorUsuario jugador1= new JugadorUsuario(nombreJugador.getText());
		JugadorOrdenador jugador2 =new JugadorOrdenador("HAL");
    	Partida partida = new Partida(jugador1,jugador2);
    	    	
    	Node node = (Node) event.getSource();
  	  Stage stage = (Stage) node.getScene().getWindow();
  	  
  	  stage.setUserData(partida);
    	
		
	}



	private void mostrarPantallaPartida(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();
    	  Stage stage = (Stage) node.getScene().getWindow();
    	  stage.close();
    	  
    	     Scene scene = Juego3RayaSpringFxApplication.loadView("juego", "application");
    	    stage.setTitle("Juego3Raya JavaFX");
    	    stage.setScene(scene);
    	    stage.show();
    	
	}



	
}
