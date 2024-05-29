package Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class DeleteView  implements EventHandler<ActionEvent>{
	//to get inventory method from Inventory class and return inventory 
	Inventory inventory = Inventory.getInventory();
	Stage stage4 = new Stage();//create new stage object
	@Override
	public void handle(ActionEvent arg0) {
		
		try {
		HBox HB = new HBox(15);// create HBox to add delete and cancel button
		Button DeleteButton = new Button("Delete");
		Button cancelButton = new Button("Cancel");	
		HB.getChildren().addAll(DeleteButton,cancelButton);
		HB.setAlignment(Pos.CENTER );
		HB.setPadding(new Insets(30,160 ,80 , 0));//spacing between HBox and pane
		
		
		GridPane GP = new GridPane();// create Grid pane to add label,text field and combo box
		Label typeLabel = new Label("Type");
		typeLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
		Label quantityLabel = new Label("Quantity");
		quantityLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
		Label priceLabel= new Label("Price");
		priceLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
		GP.setVgap(15);// spacing between nodes vertically
		GP.setHgap(40);// spacing between nodes horizontally
		TextField typeTF = new TextField();
		typeTF.setText("Item Type");
		TextField quantityTF = new TextField();
		TextField priceTF = new TextField();
		TextField brandTF = new TextField();
		brandTF.setVisible(false);
		brandTF.setText("Brand Name");// to set text inside text field
		ComboBox<String> methodsComboBox = new ComboBox<>();//create combo box to store list of item
		methodsComboBox.getItems().addAll("Brand","Not Brand");
		methodsComboBox.setMaxWidth(150);
		//add nodes in Grid pane
		GP.add(methodsComboBox, 1, 0);
		GP.add(typeLabel, 0, 1);
		GP.add(quantityLabel, 0, 2);
		GP.add(priceLabel, 0, 3);
		GP.add(typeTF, 1, 1);
		GP.add(quantityTF, 1, 2);
		GP.add(priceTF, 1, 3);
		GP.add(brandTF, 2, 1);
		
		
		//create border pane to add Grid pane and HBox pane.
		BorderPane BP = new BorderPane();
	    BP.setPadding(new Insets(5, 40, 160,3 ));
		BP.setCenter(GP);
		BP.setBottom(HB);
		BP.setAlignment(GP, Pos.CENTER_LEFT);
		BP.setStyle("-fx-background-color:lightgray;");// to set color of the border pane
		
		
		//to control when click on  combo box 
		methodsComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent handle) {
				if(methodsComboBox.getValue() == "Brand") 
					brandTF.setVisible(true);// show brand text field
				else 
					brandTF.setVisible(false);// not show brand text filed
			}
		});
		
		// to control when click on Delete Button
		DeleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int item = -1;
				if(methodsComboBox.getValue() == "Brand") {
					item = inventory.findItem(typeTF.getText(), false, brandTF.getText());
				}
				else {
					item = inventory.findItem(typeTF.getText(), false);
				}
 
				if(item != -1) {
					inventory.deleteItem(item);
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("DELETE INFORMATION");
					alert.setContentText("item deleted successfully");
					alert.showAndWait();
				}
				else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("DELETE INFORMATION");
					alert.setContentText("item not found!!");
					alert.showAndWait();
				}
			}
		});
		
		// to control when click on cancel button
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent cancel) {
				stage4.close();
			}
		});
		
		
		Scene scene = new Scene(BP);//create scene and add Grid pane
		stage4.setScene(scene);
		stage4.setResizable(false);//set size of the stage fixed
		stage4 .setWidth(600);
		stage4.setHeight(400);
		stage4.setTitle("Delete Item");
		stage4.show();//to show the stage
		}
		catch (NullPointerException e) {
			System.out.println(e);
		}
		
	 }

	}



