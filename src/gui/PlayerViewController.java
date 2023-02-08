package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.entities.Player;

public class PlayerViewController implements Initializable {
	
	
	private Player player;
	
	@FXML
	private Label labelTitle;
	
	@FXML
	private Label labelName;
	
	@FXML
	private Label labelOverall;
	
	@FXML
	private Label labelCondition;
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println("PlayerViewController");
	}	

	public void loadPlayerInfo(Player player) {
		labelTitle.setText(player.getName());
		labelName.setText(player.getName());
		labelOverall.setText(String.valueOf(player.getOverall()));
		labelCondition.setText(player.getCondition().name());
	}
	
}
