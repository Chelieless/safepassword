package me.Razvan;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


@SuppressWarnings("unused")
public class interfata extends Application{
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	static Stage window;
	Button quit, generate;
	Label text, copyright;
	CheckBox special;
	TextField size, generated;
	static boolean specialChecked = false;
	
	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setTitle("Safe Password Generator - v1");
		window.setResizable(false);
		window.setMinHeight(200);
		window.setMinWidth(550);
		window.setOnCloseRequest(e -> {
			
			e.consume();
			quit();
			
		});
		
		quit = new Button("Quit");
		generate = new Button("Generate");
		size = new TextField();
		text = new Label("Password Length: ");
		copyright = new Label("Random Password Generator v1\nContact author: skopeee@gmail.com");
		special = new CheckBox("Use special characters?");
		size.setPromptText("Enter your maximum password length here");
		generated = new TextField();
		generated.setEditable(false);
		generated.setPromptText("Generated password goes here");
		quit.setOnAction(e -> quit());
		generate.setOnAction(e -> {
			
			if(special.isSelected()) specialChecked = true;
			generated.setText(Generate(size, specialChecked));
			specialChecked = false;
			
			
		});
		
		HBox info = new HBox();
		info.getChildren().add(copyright);
		info.setAlignment(Pos.BASELINE_RIGHT);
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(generate, quit);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(5);
		
		HBox input = new HBox();
		input.getChildren().addAll(text, size, special);
		input.setAlignment(Pos.CENTER);
		input.setSpacing(10);
		
		VBox panel = new VBox();
		panel.getChildren().addAll(input, generated, buttons, info);
		panel.setSpacing(25);
		panel.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(panel);
		window.setScene(scene);
		window.show();
		
	}
	
	private static String Generate(TextField len, boolean special) {
		
		String pass = null;
		
		try {
			
			int length = Integer.parseInt(len.getText());
			if(length <= 0 || length > 128) error();
			if(length > 0 && length <= 128) pass = generator.Generate(length, special);
			
		} catch(NumberFormatException e) {
			
			error();
		}
		
		return pass;
	}
	
	private static void quit() {
		
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
	
	private static void error() {
		
		window = new Stage();
		window.setTitle("Error");
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinHeight(150);
		window.setMinWidth(350);
		
		Button ok = new Button("OK");
		Label error = new Label("You can only enters numbers in password length box (1 - 128)");
		
		ok.setOnAction(e -> window.close());
		
		VBox panel = new VBox();
		panel.getChildren().addAll(error, ok);
		panel.setAlignment(Pos.CENTER);
		panel.setSpacing(25);
		
		Scene scene = new Scene(panel);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
}
