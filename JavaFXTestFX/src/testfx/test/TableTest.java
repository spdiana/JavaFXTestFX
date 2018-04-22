package testfx.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.Assertions;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.controls.TableViews;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class TableTest extends GuiTest {

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
		click("#menuB");
		sleep(2, TimeUnit.SECONDS);
		click("#menuItemScreenB");
		
	
		TableView<?> tv = (TableView<?>)find("#tableView");
		waitUntil(tv, TableViews.containsCell("P1"));
		Assertions.verifyThat("#tableView", TableViews.containsCell("P1"));
		
	}


	@After
	public void tearDown()  {


	}
}
