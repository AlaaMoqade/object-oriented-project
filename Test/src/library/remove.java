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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class remove implements EventHandler<ActionEvent> {
	Stage stage3 = new Stage();

	@Override
	public void handle(ActionEvent arg0) {

		javafx.scene.image.Image image = new javafx.scene.image.Image(
				"C:\\Users\\amjad\\Downloads\\White Blue Orange Aesthetic Simple Lettering Books Instagram Post  (1).png");
		ImageView imageView = new ImageView(image);

		Button b1 = new Button("remove");
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

		HBox h = new HBox(20);
		h.getChildren().addAll(b1, b2);
		h.setAlignment(Pos.CENTER_LEFT);

		GridPane gp = new GridPane();

		Label la  = new Label("choose the Book you want to remove it :");
		la.setFont(Font.font(null, FontWeight.BOLD, 25));

		Label l1 = new Label("Titel");
		l1.setFont(Font.font(null, FontWeight.BOLD, 20));

		Label l2 = new Label("ISBN");
		l2.setFont(Font.font(null, FontWeight.BOLD, 20));

		Label l3 = new Label("Author");
		l3.setFont(Font.font(null, FontWeight.BOLD, 20));

		Label l4 = new Label("Number of copies");
		l4.setFont(Font.font(null, FontWeight.BOLD, 20));

		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();

		gp.setVgap(15);
		gp.setHgap(15);

		
		gp.add(l1, 0, 1);
		gp.add(l2, 0, 2);
		gp.add(l3, 0, 3);
		gp.add(l4, 0, 4);
		gp.add(t1, 1, 1);
		gp.add(t2, 1, 2);
		gp.add(t3, 1, 3);
		gp.add(t4, 1, 4);
		
		gp.setAlignment(Pos.TOP_LEFT);
		
        b.setTop(la);
		b.setCenter(gp);
		b.setBottom(h);
		b.setPadding(new Insets(30, 0, 230, 30));

		StackPane root = new StackPane();
		root.getChildren().addAll(imageView, b);

		Scene scene = new Scene(root, 600, 600);
		stage3.setScene(scene);
		stage3.setResizable(false);
		stage3.setTitle("add");
		stage3.show();

	}

}

