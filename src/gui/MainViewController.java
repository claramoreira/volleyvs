package gui;

import java.awt.MenuItem;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemGame;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	private void onMenuItemGameAction() {
		System.out.println("onMenuItemGameAction");
	}

	@FXML
	private void onMenuItemAboutAction() {
		System.out.println("onMenuItemAboutAction");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Loading MainView");
	}

}
