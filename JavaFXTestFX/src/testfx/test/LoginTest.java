package testfx.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginTest extends GuiTest {

	@Override
	protected Parent getRootNode() {
		Parent parent = null;
		try {
			parent = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return parent;
	}
	


	@Test
	public void test() {
		TextField textField = find("#txtName");
		String text = "1";
		click(textField).type(text);

		sleep(3, TimeUnit.SECONDS);

		TextField textField2 = find("#txtPassword");
		String text2 = "1";
		click(textField2).type(text2);
		sleep(3, TimeUnit.SECONDS);
		
		click("#btnLogin");
		sleep(3, TimeUnit.SECONDS);
		
		click("#menuFile");
		sleep(3, TimeUnit.SECONDS);
		click("#menuItemClose");
		
		
		 		

	}
}
