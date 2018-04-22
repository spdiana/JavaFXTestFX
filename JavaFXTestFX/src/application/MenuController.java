package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import sample.data.Repository;


public class MenuController implements Initializable {

	@FXML
	private AnchorPane centerPane;

	@FXML
	private MenuItem menuItemClose;

	@FXML
	private MenuItem menuItemScreenA;

	@FXML
	private MenuItem menuItemScreenB;

	@FXML
	private MenuItem menuItemScreenC;

	@FXML
	public void actionMenuItem(ActionEvent e) {

		if(e.getSource() == menuItemClose) {
			Platform.exit();
		}else if (e.getSource() == menuItemScreenA) {
			load("ScreenA.fxml");	
		} else if(e.getSource() == menuItemScreenB) {
			load("ScreenB.fxml");
		} else if(e.getSource() == menuItemScreenC) {
			load("ScreenC.fxml");
		}
	}

	public void load(String file) {
		try {
			FXMLLoader fxLoader = new FXMLLoader(getClass().getResource(file));
			centerPane.getChildren().clear();
			centerPane.getChildren().add(fxLoader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Repository.loadRepository();
	}
	

}
