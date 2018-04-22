package testfx.test;


import static  org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.Commons.hasText;
import static org.loadui.testfx.controls.TableViews.numberOfRowsIn;
import static org.hamcrest.Matchers.equalTo; 
import static org.hamcrest.Matchers.greaterThan; 

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.controls.TableViews;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class SearchBookTest extends GuiTest {

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
		click("#menuC");
		sleep(2, TimeUnit.SECONDS);
		click("#menuItemScreenC");
		click("#tabB");
		click("#filterField").type("ko");
	
		TableView<?> tv = (TableView<?>)find("#tableView");
		
		verifyThat(numberOfRowsIn("#tableView"), equalTo(1));
		waitUntil(tv, TableViews.containsCell("Kotlin in Action"));
		System.out.println(tv.getItems().size());
	}


	@After
	public void tearDown()  {


	}
}
