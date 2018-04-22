package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.data.Book;
import sample.data.Repository;

public class TabPaneAController {

	@FXML
	private TextField txtISBN;


	@FXML
	private TextField txtBookName;


	@FXML
	private TextField txtYearBook;
	
	@FXML
	private Label txtLabel;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnCancel;



	@FXML
	public void addAction(ActionEvent ev) {
			if(ev.getSource()== btnCancel) {
				txtISBN.setText("");
				txtBookName.setText("");
				txtYearBook.setText("");
			}else if(ev.getSource()== btnAdd) {
				Book p = new Book();
				p.setIsbnBook(Integer.parseInt(txtISBN.getText()));
				p.setBookName(txtBookName.getText());
				p.setYearBook(txtYearBook.getText());
				Repository.add(p);
				
				txtLabel.setText("Data saved");
				
				txtISBN.setText("");
				txtBookName.setText("");
				txtYearBook.setText("");
			}
		}

	}

