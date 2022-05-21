package com.softgraf.control;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application { //application é o main do javaFX

	public static void main(String[] args) {
		launch(args);
	}
	//mostra o visor -calculadora
	@Override
	public void start(Stage stage) throws Exception {
		// encontra o caminho do FXML
		URL fxml = this.getClass().getResource("/com/softgraf/view/TelaCalc.fxml");
		//agora carrega o FXML para uma variável Java
		Parent painel = (Parent) FXMLLoader.load(fxml); // importa
		
		stage.setScene(new Scene(painel)); // importa
		stage.setTitle("Calculadora FX");
		stage.setResizable(false);
		stage.show();
		
	}
	

}
