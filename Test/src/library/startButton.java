package library;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class startButton implements EventHandler<ActionEvent> {
	Stage stage2 = new Stage();

	@Override
	public void handle(ActionEvent arg0) {

		HBox h = new HBox(16);

		Button read = new Button(" click to Read file then start!!");
		read.setStyle("-fx-background-color: lightblue; -fx-font-size: 20px;");
		read.setAlignment(Pos.CENTER);

		Button b1 = new Button("ADD");
		b1.setOnAction(new ADD());

		Button b2 = new Button("remove");
		b2.setOnAction(new remove());
		Button b3 = new Button("upDate");
		b3.setOnAction(new update());
		
		Button b5 = new Button("save");
		b5.setOnAction(new save());
		Button b4 = new Button("Report");
		b4.setOnAction(new report());

		javafx.scene.image.Image image = new javafx.scene.image.Image(
				"C:\\Users\\amjad\\Downloads\\White Blue Orange Aesthetic Simple Lettering Books Instagram Post  (1).png");
		ImageView imageView = new ImageView(image);

		b1.setStyle("-fx-background-color: white; -fx-font-size: 20px;");
		b2.setStyle("-fx-background-color: white; -fx-font-size: 20px;");
		b3.setStyle("-fx-background-color: white; -fx-font-size: 20px;");
		b4.setStyle("-fx-background-color: white; -fx-font-size: 20px;");
		b5.setStyle("-fx-background-color: white; -fx-font-size: 20px;");

		h.getChildren().addAll(b1, b2, b3, b4, b5);
		h.setAlignment(Pos.CENTER);
		h.setVisible(false);

		StackPane root = new StackPane();
		root.getChildren().addAll(imageView, read, h);


		read.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				h.setVisible(true);
				read.setVisible(false);

			}
		});

		Scene scene = new Scene(root, 800, 800);
		stage2.setScene(scene);
		stage2.setResizable(false);
		stage2.setTitle("start");
		stage2.show();

	}

}
