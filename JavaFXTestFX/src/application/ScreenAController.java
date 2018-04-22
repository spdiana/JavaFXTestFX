package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import sample.data.Repository;

public class ScreenAController implements Initializable {

	@FXML
	ComboBox<String> comboBox;

	@FXML
	Label txtLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<String> list = Repository.listAllBookName();
		ObservableList<String> obs = FXCollections.observableList(list);
		comboBox.getItems().clear();
		comboBox.setItems(obs);

		comboBox.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> txtLabel.setText(newValue));
	}


}
