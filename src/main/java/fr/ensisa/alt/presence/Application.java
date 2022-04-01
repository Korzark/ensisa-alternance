package fr.ensisa.alt.presence;

import fr.ensisa.alt.presence.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("app.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 550, 700);
		stage.setTitle("Présence ENSISA");
		stage.getIcons().add(new Image(Objects.requireNonNull(Application.class.getResourceAsStream("favicon.png"))));
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}