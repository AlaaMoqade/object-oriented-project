package library;

	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.image.ImageView;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
	import javafx.scene.text.FontWeight;
	import javafx.stage.Stage;

	public class save implements EventHandler<ActionEvent> {
		Stage stage3 = new Stage();

		@Override
		public void handle(ActionEvent arg0) {

			javafx.scene.image.Image image = new javafx.scene.image.Image(
					"C:\\Users\\amjad\\Downloads\\White Blue Orange Aesthetic Simple Lettering Books Instagram Post  (1).png");
			ImageView imageView = new ImageView(image);

			Button b1 = new Button("SAVE");
			b1.setStyle("-fx-background-color: white; -fx-font-size: 15px;");
			Button b2 = new Button("Cancel");
			b2.setStyle("-fx-background-color: white; -fx-font-size: 15px;");

			b2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					stage3.close();
				}
			});

			BorderPane b = new BorderPane();
			GridPane gp = new GridPane();

			HBox h = new HBox(20);
			h.getChildren().addAll(b1, b2);
			h.setAlignment(Pos.CENTER);

			

			Label la  = new Label("Enter the file name you want to save the update to :");
			la.setFont(Font.font(null, FontWeight.BOLD, 20));
			la .setTextFill(Color.DARKBLUE);
			
			TextField t1 = new TextField();
			t1.setPrefWidth(10);
	        t1.setPrefHeight(10);
	        
	        gp.add(la, 0, 1);
			gp.add(t1, 0, 2);
			gp.setVgap(25);
			
	        
			b.setCenter(gp);
			b.setBottom(h);
			b.setPadding(new Insets(30, 30, 340, 30));

			StackPane root = new StackPane();
			root.getChildren().addAll(imageView, b);

			Scene scene = new Scene(root, 600, 600);
			stage3.setScene(scene);
			stage3.setResizable(false);
			stage3.setTitle("save");
			stage3.show();

		}

	}

