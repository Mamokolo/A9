package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane mainAnchorPane = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));;
		Scene scene = new Scene(mainAnchorPane);
		Controller controller = new Controller(scene);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
