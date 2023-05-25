package com.juego;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Juego3RayaJFX extends Application {

	
	public static void main(String[] args) {

		Juego3RayaJFX juego = new Juego3RayaJFX();
		launch(args);		

	}


	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setScene(loadView("inicio", "application"));
			primaryStage.setTitle("JUEGO EN TRES EN RAYA");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static Scene loadView(String view, String style) throws IOException {

		Parent root = FXMLLoader.load(Juego3RayaJFX.class.getClassLoader().getResource("fxml/"+view + ".fxml"));

		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(Juego3RayaJFX.class.getClassLoader().getResource("css/"+style + ".css").toExternalForm());
		return scene;
	}

}
