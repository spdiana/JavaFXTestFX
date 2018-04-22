package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class ScreenCController implements Initializable{

	@FXML
	private TabPane tabPaneRoot;

	@FXML
	private Tab tabA;

	@FXML
	private Tab tabB;

	@FXML
	private AnchorPane anchorPaneTabA;

	@FXML
	private AnchorPane anchorPaneTabB;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		load(anchorPaneTabA, "TabPaneA.fxml");

		tabPaneRoot.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
			if (newTab == tabA) {
				load(anchorPaneTabA, "TabPaneA.fxml");
			} else if (newTab == tabB) {
				load(anchorPaneTabB, "TabPaneB.fxml");
			}
		});
	}


	public void load(AnchorPane pane, String file) {
		try {
			FXMLLoader fxLoader = new FXMLLoader(getClass().getResource(file));
			pane.getChildren().clear();
			pane.getChildren().add(fxLoader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

