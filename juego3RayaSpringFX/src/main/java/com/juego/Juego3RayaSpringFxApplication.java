package com.juego;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class Juego3RayaSpringFxApplication extends Application {

	public static void main(String[] args) {
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

		Parent root = FXMLLoader.load(Juego3RayaSpringFxApplication.class.getClassLoader().getResource("fxml/"+view + ".fxml"));

		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(Juego3RayaSpringFxApplication.class.getClassLoader().getResource("css/"+style + ".css").toExternalForm());
		return scene;
	}

}
