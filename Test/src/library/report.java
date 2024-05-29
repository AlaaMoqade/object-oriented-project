package library;

import java.awt.TextArea;

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

public class report implements EventHandler<ActionEvent> {
	Stage stage3 = new Stage();

	@Override
	public void handle(ActionEvent arg0) {

		javafx.scene.image.Image image = new javafx.scene.image.Image(
				"C:\\Users\\amjad\\Downloads\\White Blue Orange Aesthetic Simple Lettering Books Instagram Post  (1).png");
		ImageView imageView = new ImageView(image);

		Button b1 = new Button("next");
		b1.setStyle("-fx-background-color: lightblue; -fx-font-size: 15px;");
		
		Button b2 = new Button("privous");
		b2.setStyle("-fx-background-color: lightblue; -fx-font-size: 15px;");
		
		Button b3 = new Button("Cancel");
		b3.setStyle("-fx-background-color: lightblue; -fx-font-size: 15px;");

		b3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				stage3.close();
			}
		});

		BorderPane b = new BorderPane();
		

		HBox h = new HBox(20);
		h.getChildren().addAll(b1, b2,b3);
		h.setAlignment(Pos.CENTER);

		Label la = new Label("click next or privous to show information about Book :");
		la.setFont(Font.font(null, FontWeight.BOLD, 20));
		la.setTextFill(Color.DARKBLUE);
		la.setAlignment(Pos.CENTER);

		
       javafx.scene.control.TextArea ta = new javafx.scene.control.TextArea();
       ta.setPrefSize(70, 70);
      
        b.setTop(la);
        b.setCenter(h);
		b.setBottom(ta);
		b.setPadding(new Insets(70, 30, 320, 30));
		
		
		
		StackPane root = new StackPane();
		root.getChildren().addAll(imageView,b);

		Scene scene = new Scene(root, 600, 600);
		stage3.setScene(scene);
		stage3.setResizable(false);
		stage3.setTitle("save");
		stage3.show();

	}

}
