package Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class AddView implements EventHandler<ActionEvent>{
	//to get inventory method from Inventory class and return inventory
	Inventory inventory = Inventory.getInventory();
	Stage stage2 = new Stage();//create new stage to show Add view
	
	@Override
	public void handle(ActionEvent arg0) {
		try {
		
		// HBox pane to add brand label , yes and No button
		HBox actionButtons2 = new HBox(55);
		Label brandLabel = new Label("Brand");
		brandLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
		RadioButton yesbutton = new RadioButton("yes");
		RadioButton Nobutton  = new RadioButton("No");
		
		
		// HBox pane to add save and cancel button
		HBox actionButton3 = new HBox(13);
		Button saveButton = new Button("Save");
		Button cancelButton = new Button("Cancel");
		actionButton3.setAlignment(Pos.CENTER);
		actionButton3.setPadding(new Insets(0, 0, 160, 80));
		actionButton3.getChildren().addAll(saveButton,cancelButton);
		
		// Grid pane to add label and text field
		GridPane GP = new GridPane(); 
		Label Typelabel = new Label("Type");
		Typelabel.setFont(Font.font(null, FontWeight.BOLD,15));
		Label Quantitylabel = new Label("Quantity");
		Quantitylabel.setFont(Font.font(null, FontWeight.BOLD, 15));
		Label Pricelabel = new Label("Price");
		Pricelabel.setFont(Font.font(null, FontWeight.BOLD, 15));
		Label brandName = new Label("Brand Name");
		brandName.setFont(Font.font(null, FontWeight.BOLD, 15));
		TextField brandTF = new TextField();
		GP.setVgap(15);//spacing between nodes vertically
		GP.setHgap(40);//spacing between nodes horizontally
		TextField typeTF = new TextField();
		TextField quantityTF = new TextField();
		TextField priceTF = new TextField();
		//add nodes on Grid pane
		GP.add(actionButtons2, 0, 0);
		GP.add(Typelabel, 0, 1);
		GP.add(Quantitylabel, 0, 2);
		GP.add(Pricelabel, 0, 3);
		GP.add(typeTF, 1, 1);
		GP.add(quantityTF, 1, 2);
		GP.add(priceTF, 1, 3);
		
		
		// border pane to add all the pane containing nods
		BorderPane BP = new BorderPane();
	    BP.setPadding(new Insets(2, 2, 160,2 ));//spacing from pane and all nodes
		BP.setTop(actionButtons2);
		BP.setCenter(GP);
		BP.setBottom(actionButton3);
		BP.setAlignment(actionButtons2,Pos.TOP_LEFT);
		BP.setAlignment(GP, Pos.CENTER_LEFT);
		BP.setStyle("-fx-background-color:lightgray;");// to set color of the border pane
		GP.add(brandName, 0, 4);
	    GP.add(brandTF, 1, 4);
	    
	    //add nodes on the first HBox
	    Nobutton.setSelected(true);
		ToggleGroup tg = new ToggleGroup();// to selected just on option
		yesbutton.setToggleGroup(tg);
		Nobutton.setToggleGroup(tg);
		actionButtons2.getChildren().addAll(brandLabel, yesbutton,Nobutton);
		brandName.setVisible(false);
	    brandTF.setVisible(false);
	    
		
		//to control the yes button when selected it
		yesbutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent yes) {
			  brandName.setVisible(true);
			  brandTF.setVisible(true);
			  BP.setPadding(new Insets(2, 2, 135,2 ));
			  actionButton3.setPadding(new Insets(20, 0, 100, 80));
			}
		});
		
		//to control the No button when selected it
		Nobutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent No) {
				  brandName.setVisible(false);
				  brandTF.setVisible(false);
				  BP.setPadding(new Insets(2, 2, 160,2 ));
				  actionButton3.setPadding(new Insets(0, 0, 160, 80));
			}
		});
		
		//to add new item when pressed  on the save Button by inventory calling true method
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent save) {
				if(Nobutton.isSelected()) {
					if(inventory.findItem(typeTF.getText(), false) != -1) {
						Label label = new Label(typeTF.getText() +" already exists");
						label.setFont(Font.font(null, FontWeight.BOLD, 20));
						label.setTextFill(Color.RED);
                        label.setAlignment(Pos.BOTTOM_LEFT);
                        label.setPadding(new Insets(0, 50, 20, 20));
                        BP.setBottom(label);
						
					} else {
						inventory.newItem(typeTF.getText(), Integer.parseInt(quantityTF.getText()), Integer.parseInt(priceTF.getText()));
					}
					
				}
				else {
					if(inventory.findItem(typeTF.getText(), false, brandTF.getText()) != -1) {
						Label label = new Label(typeTF.getText() +" already exists");
						label.setFont(Font.font(null, FontWeight.BOLD, 20));
						label.setTextFill(Color.RED);
                        label.setAlignment(Pos.BOTTOM_LEFT);
                        label.setPadding(new Insets(0, 50, 20, 20));
                        BP.setBottom(label);
						
					} else {
				        inventory.newItem(brandTF.getText(),typeTF.getText(), Integer.parseInt(quantityTF.getText()), Integer.parseInt(priceTF.getText()));
					}
				}
			  }
		});
		
		
		//to close the Add stage
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent cancel) {
				stage2.close();
			}
		});
		
		Scene scene = new Scene(BP);//to display  border pane 
		stage2.setScene(scene);//to display scene
		stage2.setResizable(false);//to put a fixed stage size
		stage2 .setWidth(400);
		stage2.setHeight(400);
		stage2.setTitle("Add New Item");
		stage2.show();
	  
		  }
		catch (NullPointerException e) {
			System.out.println(e);
		}
	}
}

   





