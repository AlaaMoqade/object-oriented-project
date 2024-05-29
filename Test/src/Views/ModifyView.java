package Views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ModifyView implements EventHandler<ActionEvent> {
	//to get inventory method from Inventory class and return inventory
	Inventory inventory = Inventory.getInventory();
	Stage stage3 = new Stage();// create new stage

	@Override
	public void handle(ActionEvent Modify) {
		
		try {

		// create HBox pane to put update and cancel button
		HBox HB = new HBox(15);
		Button UpdateButton = new Button("Update");
		UpdateButton.setDisable(true);
		Button cancelButton = new Button("Cancel");
		HB.getChildren().addAll(UpdateButton, cancelButton);
		HB.setAlignment(Pos.CENTER);
		HB.setPadding(new Insets(30, 160, 80, 0));

		// create Grid pane
		GridPane GP = new GridPane();
		Label typeLabel = new Label("Type");
		typeLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
		Label quantityLabel = new Label("Quantity");
		quantityLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
		Label priceLabel = new Label("Price");
		priceLabel.setFont(Font.font(null, FontWeight.BOLD, 15));

		GP.setVgap(15);// spacing between nodes vertically
		GP.setHgap(40);// spacing between nodes horizontally
		TextField typeTF = new TextField();
		TextField quantityTF = new TextField();
		TextField priceTF = new TextField();
		TextField brandTF = new TextField();
		brandTF.setVisible(false);
		Button searchButton = new Button("Search");
		typeTF.setText("Item Type");
		brandTF.setText("Brand Name");
		

		ComboBox<String> methodsComboBox = new ComboBox<>();
		methodsComboBox.getItems().addAll("Brand", "Not Brand");
		methodsComboBox.setMaxWidth(150);
		// add nodes in grid pane
		GP.add(methodsComboBox, 1, 0);
		GP.add(typeLabel, 0, 1);
		GP.add(quantityLabel, 0, 2);
		GP.add(priceLabel, 0, 3);
		GP.add(typeTF, 1, 1);
		GP.add(quantityTF, 1, 2);
		GP.add(priceTF, 1, 3);
		

		// create border pane
		BorderPane BP = new BorderPane();
		BP.setPadding(new Insets(5, 40, 160, 3));
		// add nodes in border pane
		BP.setCenter(GP);
		BP.setBottom(HB);
		BP.setAlignment(GP, Pos.CENTER_LEFT);
		BP.setStyle("-fx-background-color:lightgray;");//create color of the pane

		// to control when click on combo box
		methodsComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (methodsComboBox.getValue() == "Brand") {
					brandTF.setVisible(true);
					GP.add(brandTF, 2, 1);
					GP.add(searchButton, 3, 1);

				} else {
					brandTF.setVisible(false);
					GP.add(searchButton, 2, 1);
				}

			}
		});
        // to do search if item exists or not
		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int itemIndex = -1;
				if (methodsComboBox.getValue() == "Brand") {
					itemIndex = inventory.findItem(typeTF.getText(), false, brandTF.getText());
				} else {
					itemIndex = inventory.findItem(typeTF.getText(), false);
				}
				if (itemIndex != -1) {
					Item item = inventory.getItem(itemIndex);
					quantityTF.setText(String.valueOf(item.getQuantity()));
					priceTF.setText(String.valueOf(item.getPrice()));
					UpdateButton.setDisable(false);

				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setContentText("cannot find Item Type");
					alert.showAndWait();
					UpdateButton.setDisable(true);
				}
			}
		});
        // to do update on item entered
		UpdateButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int itemIndex ;
				if (methodsComboBox.getValue() == "Brand") {
					itemIndex = inventory.findItem(typeTF.getText(), false, brandTF.getText());
				} else {
					itemIndex = inventory.findItem(typeTF.getText(), false);
				}
				if (itemIndex != -1) {
					Item item = inventory.getItem(itemIndex);
					item.setPrice(Double.valueOf(priceTF.getText()));
					item.setQuantity(Integer.valueOf(quantityTF.getText()));
				}
			}
		});
		
        // to close Modify stage
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage3.close();
			}
		});

		Scene scene = new Scene(BP);// create scene to show border pane
		stage3.setScene(scene);// show scene
		stage3.setResizable(false);// size stage fixed
		stage3.setWidth(600);
		stage3.setHeight(400);
		stage3.setTitle("Update Item");// title of the stage
		stage3.show();// show the stage

	}
		catch (NullPointerException e) {
			System.out.println(e);
		}
	}	
}
