package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField txtName;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private Button btnCancel;

	@FXML
	private Button btnLogin;

	@FXML
	public void loginAction(ActionEvent ev) {
		if(ev.getSource()== btnCancel) {
			txtName.setText("");
			txtPassword.setText("");
		} else if(ev.getSource()== btnLogin) {

			if(txtName.getText().equals("1") && txtPassword.getText().equals("1") ) {

				try {
					//Form 1
					//					btnLogin.getScene().setRoot((Parent) fxmlloader.load());


					//Form 2
					//					((Node) (ev.getSource())).getScene().getWindow().hide();
					//					Parent root1 = (Parent) fxmlloader.load();
					//					Stage stage = new Stage();
					//					stage.setScene(new Scene(root1));  
					//					stage.show();


					//Form 3
					Parent window3 = (AnchorPane)FXMLLoader.load(getClass().getResource("Menu.fxml"));
					Scene newScene = new Scene(window3);
					Stage mainWindow  = (Stage)  ((Node)ev.getSource()).getScene().getWindow();
					mainWindow.setScene(newScene); 


				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {

			}
		}
	}
}
