package testfx.test;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.Commons.hasText;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;


public class ComboBoxTest extends GuiTest {

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

	@Before
	public void login() {
		TextField textField = find("#txtName");
		String text = "1";
		click(textField).type(text);

		sleep(1, TimeUnit.SECONDS);

		TextField textField2 = find("#txtPassword");
		String text2 = "1";
		click(textField2).type(text2);
		sleep(1, TimeUnit.SECONDS);

		click("#btnLogin");
		sleep(1, TimeUnit.SECONDS);
	}

	@Test
	public void menu() {
		click("#menuA");
		sleep(2, TimeUnit.SECONDS);
		click("#menuItemScreenA");
		click("#comboBox");
		sleep(2, TimeUnit.SECONDS);
		type(KeyCode.DOWN);
		type(KeyCode.DOWN);
		sleep(2, TimeUnit.SECONDS);
		type(KeyCode.ENTER);
			
		verifyThat("#txtLabel", hasText("Londres"));
	}


	@After
	public void tearDown()  {


	}
}
