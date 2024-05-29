package library;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class vieww extends Application {
	@Override
	public void start(Stage stage1) throws Exception {

		try {

			// Create the ImageView with the image
			javafx.scene.image.Image image = new javafx.scene.image.Image(
					"C:\\Users\\amjad\\Downloads\\White Blue Orange Aesthetic Simple Lettering Books Instagram Post .png");
			ImageView imageView = new ImageView(image);

			// Create the buttons
			Button button1 = new Button("start");
			button1.setOnAction(new startButton());
			

			button1.setStyle("-fx-background-color: white; -fx-font-size: 20px;");

			// Create a VBox to hold the buttons
			HBox buttonsContainer = new HBox(20);
			buttonsContainer.setAlignment(Pos.BOTTOM_CENTER);
			buttonsContainer.getChildren().addAll(button1);

			// Create a StackPane to hold the image and buttons
			StackPane root = new StackPane();
			root.getChildren().addAll(imageView, buttonsContainer);

			// Create the scene and set it on the stage
			Scene scene = new Scene(root, 800, 800);
			stage1.setScene(scene);
			stage1.setResizable(false);
			stage1.setTitle("library");
			stage1.show();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
