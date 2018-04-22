package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.data.Book;
import sample.data.Repository;

public class TabPaneBController implements Initializable{

	@FXML
	ComboBox<String> comboBox;
	
	@FXML
	private TableView<Book> tableView;

	@FXML 
	private TableColumn<Book, Integer> col1;

	@FXML 
	private TableColumn<Book, String> col2;

	@FXML 
	private TableColumn<Book, String> col3;

	@FXML
	private TextField filterField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("Book Name");
		list.add("Year Book");
		ObservableList<String> obs = FXCollections.observableList(list);
		comboBox.setItems(obs);
		comboBox.getSelectionModel().select(0);

		
		col1.setCellValueFactory(new PropertyValueFactory<Book, Integer>("isbnBook"));
		col2.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));
		col3.setCellValueFactory(new PropertyValueFactory<Book, String>("yearBook"));
		ObservableList<Book> obsList = FXCollections.observableArrayList();
		obsList.addAll(Repository.listAll());



		FilteredList<Book> filteredData = new FilteredList<>(obsList, p -> true);
		
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(book -> {
				if (newValue == null || newValue.isEmpty()){
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (comboBox.getValue().equals("Book Name") && book.getBookName().toLowerCase().contains(lowerCaseFilter)){
					return true;
				}else if (comboBox.getValue().equals("Year Book") && book.getYearBook().contains(lowerCaseFilter)) {
                    return true; 
                }
				
				return false;
			});
		});

		SortedList<Book> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tableView.comparatorProperty());
		tableView.setItems(sortedData);
	}
}



