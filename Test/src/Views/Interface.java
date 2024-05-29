package Views;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Interface extends Application {

	public Stage stage = new Stage();// create new stage

	// to get inventory method from Inventory class and return inventory
	Inventory inventory = Inventory.getInventory();

	@Override
	public void start(Stage stage) throws NullPointerException {
		try {
			// HBox pane to add button
			HBox actionButtons = new HBox(13);

			Button addButton = new Button("Add");
			addButton.setOnAction(new AddView());// set Action when pressed it

			Button modifyButton = new Button("Modify");
			modifyButton.setOnAction(new ModifyView());// set Action when pressed it

			Button deleteButton = new Button("Delete");
			deleteButton.setOnAction(new DeleteView());// set Action when pressed it

			Button stockButton = new Button("stock report");
			stockButton.setOnAction(new StockReport());// set Action when pressed it

			actionButtons.getChildren().addAll(addButton, modifyButton, deleteButton, stockButton);
			actionButtons.setAlignment(Pos.CENTER);
			// create image and view it
			Image image = new Image("file:///C:/Users/amjad/OneDrive/Pictures/inventoryManagement.jpg");
			ImageView imageView = new ImageView(image);
			imageView.setRotate(35);

			// HBox to add label
			HBox h = new HBox();
			Label l = new Label("Inventory Management System : Comp 2311 Project, Phase 2");
			l.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
			h.setAlignment(Pos.CENTER);
			h.getChildren().add(l);

			// border pane to add image ,button and label
			BorderPane borderPane = new BorderPane();
			borderPane.setTop(h);
			borderPane.setCenter(imageView);
			borderPane.setBottom(actionButtons);
			borderPane.setAlignment(h, Pos.CENTER);// position of HBox pane on border pane
			Scene soso = new Scene(borderPane);

			// to bind this node with height an width border pane
			imageView.fitWidthProperty().bind(soso.heightProperty().multiply(0.6));
			imageView.fitHeightProperty().bind(soso.heightProperty().multiply(0.6));
			h.maxWidthProperty().bind(soso.widthProperty().multiply(0.8));
			borderPane.setStyle("-fx-background-color:lightgray;");

			stage.setWidth(600);// width of the stage
			stage.setHeight(600);// height of the stage
			stage.setResizable(false);// size of stage is fixed
			stage.setTitle("Inventory Management System");// title of the stage
			stage.setScene(soso);// to show scene
			stage.show();// show stage

		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		DataReader.readData();
		Application.launch(args);
	}
}
