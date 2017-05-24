package me.Razvan;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class interfata extends Application{
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	static Stage window;
	Button quit, generate;
	Label text;
	CheckBox special;
	TextField size;
	static boolean specialChecked = false;
	
	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setTitle("Safe Password Generator - v1");
		window.setResizable(false);
		window.setMinHeight(150);
		window.setMinWidth(550);
		window.setOnCloseRequest(e -> {
			
			e.consume();
			quit();
			
		});
		
		quit = new Button("Quit");
		generate = new Button("Generate");
		size = new TextField();
		text = new Label("Password Length: ");
		special = new CheckBox("Use special characters?");
		size.setPromptText("Enter your maximum password length here");
		
		quit.setOnAction(e -> quit());
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(generate, quit);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(5);
		
		HBox input = new HBox();
		input.getChildren().addAll(text, size, special);
		input.setAlignment(Pos.CENTER);
		input.setSpacing(10);
		
		VBox panel = new VBox();
		panel.getChildren().addAll(input, buttons);
		panel.setSpacing(25);
		panel.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(panel);
		window.setScene(scene);
		window.show();
		
	}

	private static void quit() {
		
		boolean quit = false;
		Button quitButton, cancel;
		Label text = new Label("Are you sure you want to quit?");
		quitButton = new Button("Quit");
		cancel = new Button("Cancel");
		
		window = new Stage();
		window.setTitle("Quit Program");
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinHeight(150);
		window.setMinWidth(350);
		
		quitButton.setOnAction(e -> System.exit(0));
		cancel.setOnAction(e -> window.close());
		
		HBox buttons = new HBox();
		VBox panel = new VBox();
		
		buttons.getChildren().addAll(quitButton, cancel);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(10);
		
		panel.getChildren().addAll(text, buttons);
		panel.setAlignment(Pos.CENTER);
		panel.setSpacing(25);
		
		Scene scene = new Scene(panel);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
}
