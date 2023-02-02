package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PlayerViewController implements Initializable {
	
	@FXML
	private Label labelTitle;
	
	@FXML
	private Label labelName;
	
	@FXML
	private Label labelOverall;
	
	@FXML
	private Label labelCondition;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println("PlayerViewController");
	}	

}
