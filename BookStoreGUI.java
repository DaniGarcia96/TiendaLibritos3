/**
	Class BookStoreApplication version 0.4 represents a book store.
	It gives the user the option to
		- add a book to the store's inventory
		- list all books in the store's inventory
		- search for a specific book
		
	Author: Corey Lucas
	E-mail address: clucas0044@kctcs.edu
	Last changed: 10/23/2015
	Lab 01
*/
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BookStoreGUI extends Application {
	
	private Label titleLabel;
	private Label authorLabel;
	private Label priceLabel;
	private Label sizeLabel;
	
	private TextField titleTextField;
	private TextField authorTextField;
	private TextField priceTextField;
	private TextField sizeTextField;
	
	private GridPane inputGrid;
	private GridPane topGrid;
	
	private RadioButton bookRadioButton;
	private RadioButton cdRadioButton;
	private RadioButton dvdRadioButton;
	
	private ToggleGroup itemTypeGroup;
	
	private TextArea outputTextArea;
	
	private Button addButton;
	private Button displayInventoryButton;
	
	private HBox buttonsHBox;
	private VBox radioItemTypeVBox;
	
	private BorderPane mainPane;
	
	private String title;
	private String author;
	private double price;
	private int size;
	
	private BookStoreHandler handler;
	
	static Catalog storeCatalog = new Catalog();

	public static final int ADD_ITEM = 0;
	public static final int SHOW_ITEM_LIST = 1;
	public static final int SEARCH = 2;
	public static final int QUIT = 3;
	
	public static final int BOOK = 4;
	public static final int CD = 5;
	public static final int DVD = 6;
	public static final int CANCEL = 7; 

	static int count = 0;

	static Scanner keyboard = new Scanner(System.in);
	
	public void start(Stage primaryStage) {
		
		createInputComponents();
		createOutputComponents();
		createButtons();
		createWindow();
		
		Scene scene = new Scene(mainPane, 500, 500);
		
		primaryStage.setTitle("Bookstore GUI");
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
			
	} // START METHOD
		
	private void createInputComponents(){
		
		titleLabel = new Label("Title");
		authorLabel = new Label("Author");
		priceLabel = new Label("Price");
		sizeLabel = new Label("Size(pages for book, playing time for cd/dvd):");
		
		titleTextField = new TextField();
		authorTextField = new TextField();
		priceTextField = new TextField();
		sizeTextField = new TextField();
		
		inputGrid = new GridPane();
		
		inputGrid.add(titleLabel, 0, 0);
		inputGrid.add(titleTextField, 1, 0);
		inputGrid.add(authorLabel, 0, 1);
		inputGrid.add(authorTextField, 1, 1);
		inputGrid.add(priceLabel, 0, 2);
		inputGrid.add(priceTextField, 1, 2);
		inputGrid.add(sizeLabel, 0, 3);
		inputGrid.add(sizeTextField, 1, 3);
		
		bookRadioButton = new RadioButton("Book");
		cdRadioButton = new RadioButton("CD");
		dvdRadioButton = new RadioButton("DVD");
		
		itemTypeGroup = new ToggleGroup();
		
		bookRadioButton.setToggleGroup(itemTypeGroup);
		cdRadioButton.setToggleGroup(itemTypeGroup);
		dvdRadioButton.setToggleGroup(itemTypeGroup);
		
		radioItemTypeVBox = new VBox(15);
		
		radioItemTypeVBox.getChildren().add(bookRadioButton);
		radioItemTypeVBox.getChildren().add(cdRadioButton);
		radioItemTypeVBox.getChildren().add(dvdRadioButton);
		
		bookRadioButton.setSelected(true);	
		
		topGrid = new GridPane();
		
		topGrid.setAlignment(Pos.CENTER);
		
		topGrid.add(inputGrid, 0, 0);
		topGrid.add(radioItemTypeVBox, 1, 0);
	}
	
	private void createOutputComponents(){
		
		outputTextArea = new TextArea();
		outputTextArea.setEditable(false);
			
	}
	
	private void createButtons() {
		
		addButton = new Button("Add Item");
		displayInventoryButton = new Button("Display Inventory");
		
		buttonsHBox = new HBox(25);
		
		buttonsHBox.setAlignment(Pos.CENTER);
		
		buttonsHBox.getChildren().add(addButton);
		buttonsHBox.getChildren().add(displayInventoryButton);
		
		handler = new BookStoreHandler();
		
		addButton.setOnAction(handler);
		displayInventoryButton.setOnAction(handler);
			
	}
	
	private void createWindow() {
		
		mainPane = new BorderPane();
		
		mainPane.setTop(topGrid);
		mainPane.setCenter(outputTextArea);
		mainPane.setBottom(buttonsHBox);
			
	}
	
	private class BookStoreHandler implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent ae) {
			
			if(ae.getSource() == addButton) {
				
				BookStoreItem newItem = null;
				
				title = titleTextField.getText().trim();
				author = authorTextField.getText().trim();
				price = Integer.parseInt(priceTextField.getText().trim());
				size = Integer.parseInt(sizeTextField.getText().trim());
				
				if(bookRadioButton.isSelected()){
					
					newItem = new Book(title, author, price, size);
					
				}
				else if(cdRadioButton.isSelected()) {
					
					newItem = new CD(title, author, price, size);
						
				}
				else if(dvdRadioButton.isSelected()) {
					
					newItem = new DVD(title, author, price, size);
						
				}
				
				storeCatalog.add(newItem);
				outputTextArea.appendText("\nItem was successfully added to the catalog.");
					
			}
			else if(ae.getSource() == displayInventoryButton) {
				
				outputTextArea.setText("");
				
				BookStoreItem[] list = storeCatalog.getList();
		
				for (int i = 0;i < list.length;i++) {
					
					if(list[i] != null){
						outputTextArea.appendText("\nItem " + (i + 1) + ":\n" + list[i]);
					}
				}
					
			}	
		}
			
	}	
		
	
	
}


	
	
