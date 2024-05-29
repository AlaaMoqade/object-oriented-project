package Views;

import java.awt.TextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class StockReport  implements EventHandler<ActionEvent> {
	
	//to get inventory method from Inventory class and return inventory
	Inventory inventory = Inventory.getInventory();
	Stage stage5 = new Stage();// create new stage 
	@Override
	public void handle(ActionEvent arg0) {
		
		try {
			
		// create HBox pane to put the title
		HBox labelHb = new HBox();
		Text text = new Text("The following options can be used to print a report");
		text.setFont(Font.font(null, FontWeight.BOLD, 20));
		labelHb.setAlignment(Pos.CENTER_LEFT);
		labelHb.getChildren().add(text);
		
		//create HBox to add check Box 
		GridPane GPane = new GridPane();
		Button ExportButton = new Button("Export");
		TextField reportTF = new TextField();
		reportTF.setText("MyFile.text");
		CheckBox fileBox = new CheckBox("Export a copy to a file");
		CheckBox TextBox = new CheckBox("Text Area");
		
		//HBox pane to add nodes
		HBox bbb = new HBox();
		javafx.scene.control.TextArea textArea = new javafx.scene.control.TextArea();
		textArea.setPrefWidth(400);
		textArea.setPrefHeight(1500);
		bbb.getChildren().addAll(textArea);
		bbb.setAlignment(Pos.CENTER_RIGHT);
		bbb.setPadding(new Insets(0, 40, 90, 40));
		
		ExportButton.setVisible(false);// not show export button
		reportTF.setVisible(false);// to not show
		textArea.setVisible(false);//to not show
		
		// add nodes in grid pane
		GPane.add(fileBox, 0, 0);
		GPane.add(TextBox, 1, 0);
		GPane.add(reportTF, 0, 1);
		GPane.add(ExportButton, 0, 2);
		GPane.setHgap(15);
		GPane.setVgap(3);
		
		//create VBox to add tow HBox pane vertically
		VBox vboxaction = new VBox(15);
		vboxaction.getChildren().addAll(labelHb,GPane,bbb);
		vboxaction.setPadding(new Insets(10, 2, 2, 17));
		
		//create event handler to select one option of them
	     EventHandler<ActionEvent> handle = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) { 
				if(fileBox.isSelected()) {
					reportTF.setVisible(true);
					ExportButton.setVisible(true);
				}
				else if(TextBox.isSelected()) {
					textArea.setVisible(true);
					textArea.setText(inventory.stockReport());
				}
				else if(fileBox.isSelected() || TextBox.isSelected()) {
					ExportButton.setVisible(true);
					reportTF.setVisible(true);
					textArea.setVisible(true);
				}
				else {
					ExportButton.setVisible(false);
					reportTF.setVisible(false);
					textArea.setVisible(false);
				}
			}
		};
		
		fileBox.setOnAction(handle);
		TextBox.setOnAction(handle);

		// to control when click report button an print stock report
		ExportButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				File file = new File(reportTF.getText());
                try {
					file.createNewFile();
					PrintWriter write = new PrintWriter(file);
					write.print(inventory.stockReport());
					write.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	
		Scene scene = new Scene(vboxaction);//create scene to show VBox pane
		stage5.setScene(scene);//show scene
		stage5.setResizable(false);//stage size fixed
		stage5 .setWidth(700);
		stage5.setHeight(400);
		stage5.setTitle("Stock Report");//title of the stage
		stage5.show();// to show the stage
		
	}
		catch (NullPointerException e) {
			System.out.println(e);
		}
	}
}
