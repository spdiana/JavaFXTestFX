package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.data.Book;
import sample.data.Repository;

public class ScreenBController implements Initializable{

	@FXML
	private TableView<Book> tableView;

	@FXML 
	private TableColumn<Book, Integer> col1;

	@FXML 
	private TableColumn<Book, String> col2;

	@FXML 
	private TableColumn<Book, String> col3;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		col1.setCellValueFactory(new PropertyValueFactory<Book, Integer>("isbnBook"));
		col2.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));
		col3.setCellValueFactory(new PropertyValueFactory<Book, String>("yearBook"));

		ObservableList<Book> obsList = FXCollections.observableArrayList();
		obsList.addAll(Repository.listAll());

		tableView.setItems(obsList);
	}
}

